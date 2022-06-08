package com.example.myapplication.model

data class Person(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)