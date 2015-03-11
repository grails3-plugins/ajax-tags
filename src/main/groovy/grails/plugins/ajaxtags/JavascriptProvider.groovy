package grails.plugins.ajaxtags

/**
 * Defines methods that a JavaScript provider must implement.
 *
 * @author Graeme Rocher
 */
interface JavascriptProvider {

    /**
     * Creates a remote function call
     *
     * @param The attributes to use
     * @param The output to write to
     */
    def doRemoteFunction(taglib,attrs, out)

    def prepareAjaxForm(attrs)
}
