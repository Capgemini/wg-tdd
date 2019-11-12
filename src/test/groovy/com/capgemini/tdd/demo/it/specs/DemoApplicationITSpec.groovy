package com.capgemini.tdd.demo.it.specs

import groovyx.net.http.RESTClient
import spock.lang.Specification

class DemoApplicationITSpec extends Specification {
    static String testURL = "http://localhost:8080"

    RESTClient restClient = new RESTClient(testURL)

    def "1 - The user should be greeted as 'world' when hitting the /greeting path"() {
        when: "The user hits the /greeting path"
        def response = restClient.get(path: "/greeting")

        then: "The user gets a 200 response code"
        response.status == 200

        and: "The user is greeted as 'World'"
        response.responseData.content == "Hello, World!"
    }

    def "2 - The user is greeted as 'Motto' when passing the name 'Motto' as a parameter"() {
        when: "The user hits the /greeting path with name set to Motto"
        def response = restClient.post(path: "/greeting", queryString: "name=Motto")

        then: "The user gets a 200 response code"
        response.status == 200

        and: "The user is greeted as 'Motto'"
        assert response.responseData.content == "Hello, Motto!"
    }

    def "3 - The ID is incremented by 1 each time the page is hit"() {
        when: "The user hits the /greeting path"
        def firstResponse = restClient.get(path: "/greeting")

        then: "The user gets a 200 response code"
        firstResponse.status == 200

        when: "The user hits the /greeting path for a second time"
        def secondResponse = restClient.get(path: "/greeting")

        then: "The user gets a 200 response code"
        secondResponse.status == 200

        and: "The ID is incremented by 1 for the second hit"
        assert firstResponse.responseData.id + 1 == secondResponse.responseData.id
    }

}
