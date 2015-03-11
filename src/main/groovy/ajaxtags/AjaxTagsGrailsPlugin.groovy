package ajaxtags

import grails.plugins.Plugin

class AjaxTagsGrailsPlugin extends Plugin {

   // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.0.0.M2 > *"

    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "AJAX Tags"
    def author = "Jeff Brown"
    def authorEmail = "jeff@jeffandbetsy.net"
    def description = '''\
The ajax-tags plugin provides AJAX related GSP tags.
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/ajax-tags"

    def license = "APACHE"

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GitHub Issues", url: "http://github.com/grails3-plugins/ajax-tags/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/grails3-plugins/ajax-tags/" ]

    def providedArtefacts = [AjaxTagLib]
}
