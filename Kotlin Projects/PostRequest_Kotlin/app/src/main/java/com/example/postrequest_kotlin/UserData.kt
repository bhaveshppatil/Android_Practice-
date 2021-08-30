package com.example.postrequest_kotlin

class UserData {

    private var email: String = ""
    private var title: String = ""
    private var request: String = ""

    constructor(email: String, title: String, request: String) {
        this.email = email
        this.title = title
        this.request = request
    }

}