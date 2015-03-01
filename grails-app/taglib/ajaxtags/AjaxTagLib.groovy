package ajaxtags
class AjaxTagLib {
    static defaultEncodeAs = [taglib:'html']
    static namespace = 'ajax'

    Closure remoteForm = { attrs ->
        if (attrs.params != null) {
            throwTagError("Tag [remoteForm] does not support the [params] attribute - add a 'params' key to the [url] attribute instead.")
        }
    }
}
