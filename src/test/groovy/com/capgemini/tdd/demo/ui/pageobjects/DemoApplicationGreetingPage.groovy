package com.capgemini.tdd.demo.ui.pageobjects

import geb.Page

class DemoApplicationGreetingPage extends Page {

    static url = "http://localhost:8090"

    static at = { browser.driver.currentUrl.contains(url) && greetingId.displayed }

    static content = {
        greetingId(required: true) { $("#greeting-id") }
        greetingContent(required: true) { $("#greeting-content") }
    }

}
