package com.example.kotlinhm3.models

import java.io.Serializable

data class Pictures(
    val url: String,
    var isSelected: Boolean
    ): Serializable
