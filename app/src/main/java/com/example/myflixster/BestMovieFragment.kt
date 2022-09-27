package com.example.myflixster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asynchttpclient.AsyncHttpClient
import com.example.asynchttpclient.RequestParams
import com.example.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers
import org.json.JSONObject


private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"

class BestMovieFragment : Fragment(), OnListFragmentInteractionListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.best_movie, container, false)
        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
        val recyclerView = view.findViewById<View>(R.id.list) as RecyclerView
        val context = view.context
        updateAdapter(progressBar, recyclerView)
        return view
    }


    private fun updateAdapter(progressBar: ContentLoadingProgressBar, recyclerView: RecyclerView){
        progressBar.show()

        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api-key"] = API_KEY


        client[
                "https://api.themoviedb.org/3/movie/now_playing?api_key=<<api_key>>&language=en-US&page=1",
                params,
                object : JsonHttpResponseHandler()
                {


                    override fun onSuccess(
                        statusCode: Int,
                        headers: Headers,
                        json: JsonHttpResponseHandler.JSON
                    ){
                        progressBar.hide()

                        var gson = Gson()
                        val arrayMovieType = object : TypeToken<List<BestMovie>>{}.type
                        val resultsJSON : JSONObject = json.jsonObject.get("results") as JSONObject
                        val movieRawJSON : String = resultsJSON.get("movie").toString()
                        val models : List<BestMovie> = gson.fromJson(movieRawJSON, arrayMovieType)
                        recyclerView.adapter = BestSellerBooksRecyclerViewAdapter(models, this@BestMovieFragment)
                    }

                    override fun onFailure(
                        statusCode: Int,
                        headers: Headers?,
                        errorResponse: String,
                        t: Throwable?
                    ) {
                        // The wait for a response is over
                        progressBar.hide()

                        // If the error is not null, log it!
                        t?.message?.let {
                            Log.e("BestMovieFragment", errorResponse)
                        }
                    }
                }]

    }




























    override fun onItemClick(item: BestMovie) {
        TODO("Not yet implemented")
    }

}

