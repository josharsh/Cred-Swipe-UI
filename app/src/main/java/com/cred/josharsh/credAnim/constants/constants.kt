package com.cred.josharsh.credAnim.constants

enum class ScreenTags(val tag: String) {
    SwipeResultsScreen("SwipeResultsScreen"),
    SwipeAnimScreen("SwipeAnimScreen");
    override fun toString(): String = tag
}

const val BASE_URL = "https://api.mocklets.com/p68348"

// Drag Animation States
enum class States { TOP, BOTTOM, RESET}


enum class ApiCases(val path: String){
    SuccessCase("success_case"),
    FailureCase("failure_case");
    override fun toString(): String = path
}


enum class SwipeResultMessage(val message: String){
    SuccessCase("success"),
    FailureCase("failure");
    override fun toString(): String = message
}