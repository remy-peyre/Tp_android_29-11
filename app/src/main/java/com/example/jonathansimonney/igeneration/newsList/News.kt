package com.example.g123k.myapplication

data class News(var author: String?,
                var content: String?,
                var date: String?,
                var link : String?,
                var picutre: String?,
                var summary: String?,
                var title: String?) {



    constructor() : this(null, null, null, null, null, null,null)

}