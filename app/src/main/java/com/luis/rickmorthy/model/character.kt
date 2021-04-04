package com.luis.rickmorthy.model

import java.util.ArrayList

data class character(
            val id : Int,
            val name : String,
            val status : String,
            val species : String,
            val type : String,
            val gender : String,
            val image : ArrayList<String>,
            val episode : ArrayList<String>,
            val url : String,
            val created : String,
            val location: location,
            val origin: origin)