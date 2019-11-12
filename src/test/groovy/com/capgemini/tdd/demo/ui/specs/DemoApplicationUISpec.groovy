package com.capgemini.tdd.demo.ui.specs

import com.capgemini.tdd.demo.DemoApplication
import com.capgemini.tdd.demo.ui.pageobjects.DemoApplicationGreetingPage
import geb.spock.GebSpec
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(classes = DemoApplication, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=8090")
class DemoApplicationUISpec extends GebSpec {

    def "1 - The user accesses the Greeting page and asserts the page has loaded"() {
        when: "The user navigates to the Greeting page"
        to DemoApplicationGreetingPage

        then: "The user asserts that the Greeting page has loaded"
        at DemoApplicationGreetingPage
    }

    def "2 - The user accesses the Greeting page and asserts the content text is 'Hello, World!'"() {
        when: "The user navigates to the Greeting page"
        to DemoApplicationGreetingPage

        then: "The user asserts that the Greeting page has loaded and the content text is 'Hello, World!'"
        at DemoApplicationGreetingPage
        assert greetingContent.text() == "Hello, World!"
    }

}
