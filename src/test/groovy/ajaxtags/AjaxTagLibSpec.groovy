package ajaxtags

import grails.plugins.ajaxtags.JavascriptProvider
import grails.test.mixin.TestFor
import org.grails.taglib.GrailsTagException
import spock.lang.Issue
import spock.lang.Specification

@TestFor(AjaxTagLib)
class AjaxTagLibSpec extends Specification {

    def setup() {
        tagLib.provider = new TestProvider()
    }
    void 'test remoteForm with params attribute'() {
        when:
        def template = '<g:formRemote name="myForm" url="[controller:\'person\', action:\'list\']" params="[var1:\'one\', var2:\'two\']"><g:textField name="foo" /></g:formRemote>'
        applyTemplate(template)

        then:
        GrailsTagException e = thrown()
        e.message.endsWith 'Tag [formRemote] does not support the [params] attribute - add a \'params\' key to the [url] attribute instead.'
    }

    void 'test formRemote with String url'() {
        when:
        def template = '''\
<g:formRemote name="myForm" method="GET" url="/dirt-grails/ruleDetails/saveDynamicParameters" >\
<g:textField name="foo" />\
</g:formRemote>'''
        def result = applyTemplate(template)

        then:
        result == '''\
<form onsubmit="<remote>return false" method="GET" \
action="/dirt-grails/ruleDetails/saveDynamicParameters" id="myForm"><input type="text" name="foo" value="" id="foo" /></form>'''
    }

    /**
     * <p>Tests that the 'formRemote' tag defaults to supplied 'method'
     * and 'action' attributes in fallback mode, i.e. when javascript
     * is unavailable or disabled.</p>
     *
     * <p>Also makes sure no regressions on http://jira.codehaus.org/browse/GRAILS-3330</p>
     */
    @Issue('GRAILS-3330')
    void 'test formRemote with overrides'() {
        when:
        def template = '''\
<g:formRemote name="myForm" method="GET" action="/person/showOld?var1=one&var2=two"
              url="[controller:'person', action:'show', params: [var1:'one', var2:'two']]" >\
<g:textField name="foo" />\
</g:formRemote>'''
        def result = applyTemplate(template)

        then:
        result == '''\
<form onsubmit="<remote>return false" method="GET" \
action="/person/showOld?var1=one&var2=two" id="myForm"><input type="text" name="foo" value="" id="foo" /></form>'''
    }

    @Issue('GRAILS-4672')
    void 'test remoteLink with space before GString variable'() {
        when:
        def template = '<g:remoteLink controller="people" action="theAction" params="someParams" update="success" onComplete="doSomething();" title="The Album Is ${variable}" class="hoverLT">${variable}</g:remoteLink>'
        def result = applyTemplate(template, [variable: 'Undertow'])

        then:
        result.contains 'title="The Album Is Undertow"'
    }

    @Issue('GRAILS-4672')
    void 'test remoteLink with space before and after GString variable'() {
        when:
        def template = '<g:remoteLink controller="people" action="theAction" params="someParams" update="success" onComplete="doSomething();" title="The Album Is ${variable} By Tool" class="hoverLT">${variable}</g:remoteLink>'
        def result = applyTemplate(template, [variable: 'Undertow'])

        then:
        result.contains 'title="The Album Is Undertow By Tool"'
    }
}


class TestProvider implements JavascriptProvider {

    def doRemoteFunction(Object taglib, Object attrs, Object out) {
        out << "<remote>"
    }

    def prepareAjaxForm(Object attrs) {}
}
