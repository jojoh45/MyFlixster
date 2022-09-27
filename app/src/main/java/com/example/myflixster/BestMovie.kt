package com.example.myflixster

import com.google.gson.annotations.SerializedName






class BestMovie {
    @SerializedName("movie_image")
    var moveImageUrl: String? = null

    @JvmField
    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null
}