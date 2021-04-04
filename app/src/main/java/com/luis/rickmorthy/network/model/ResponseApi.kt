package com.luis.rickmorthy.network.model

data class ResponseApi<T> (val info : Info, val results : ArrayList<T>)