package ajaxtags

import grails.test.mixin.TestFor
import org.grails.taglib.GrailsTagException
import spock.lang.Specification

@TestFor(AjaxTagLib)
class AjaxTagLibSpec extends Specification {

    void 'test remoteForm with params attribute'() {

        when:
        def template = '<ajax:remoteForm name="myForm" url="[controller:\'person\', action:\'list\']" params="[var1:\'one\', var2:\'two\']"><g:textField name="foo" /></ajax:remoteForm>'
        applyTemplate(template)

        then:
        GrailsTagException e = thrown()
        e.message.endsWith 'Tag [remoteForm] does not support the [params] attribute - add a \'params\' key to the [url] attribute instead.'
    }
}
