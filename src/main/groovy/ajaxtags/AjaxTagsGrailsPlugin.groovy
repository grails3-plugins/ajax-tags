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

    Closure doWithSpring() { {->
            // TODO Implement runtime spring config (optional)
        } 
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
