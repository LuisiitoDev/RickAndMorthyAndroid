package com.luis.rickmorthy.model

data class location (
        val id : Int,
        val name : String,
        val type : String,
        val dimension : String,
        val residens : ArrayList<String>,
        val url : String,
        val created: String
)