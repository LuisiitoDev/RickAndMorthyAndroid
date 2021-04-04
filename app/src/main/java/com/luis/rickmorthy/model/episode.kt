package com.luis.rickmorthy.model

data class episode(
    val id : Int,
    val name : String,
    val type : String,
    val dimension: String,
    val residents : ArrayList<String>,
    val url : String,
    val created : String
)