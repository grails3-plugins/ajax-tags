/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.ajaxtags

import grails.plugins.Plugin

class AjaxTagsGrailsPlugin extends Plugin {
    def grailsVersion = "4.0.0 > *"
    def title = "AJAX Tags"
    def author = "Jeff Brown"
    def authorEmail = "jeff@jeffandbetsy.net"
    def description = '''\
The ajax-tags plugin provides AJAX related GSP tags.
'''
    def profiles = ['web']
    def documentation = "http://grails.org/plugin/ajax-tags"
    def license = "APACHE"
    def issueManagement = [system: "GitHub Issues", url: "http://github.com/grails3-plugins/ajax-tags/issues"]
    def scm = [url: "https://github.com/grails3-plugins/ajax-tags/"]
    def providedArtefacts = [AjaxTagLib]
}