package com.example.myflixster

import com.google.gson.annotations.SerializedName

/**
 * The Model for storing Movies book from the Movies API
 *
 * SerializedName tags MUST match the JSON response for the
 * object to correctly parse with the gson library.
 */




class BestMovie {

    @SerializedName("backdrop_path")
    var moveImageUrl: String? = null


    @SerializedName("original_title")
    var title: String? = null


    @SerializedName("overview")
    var description: String? = null
}