package com.devpadawan.footballresults.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.devpadawan.footballresults.databinding.ActivityFootballBinding
import com.devpadawan.footballresults.model.Competition
import com.devpadawan.footballresults.service.ApiFootball
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FootballActivity : AppCompatActivity() {

    val URL = "https://api.football-data.org"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFootballBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.footballRecycler.layoutManager = LinearLayoutManager(this)
        binding.footballRecycler.adapter = null

        val retrofitFootball = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiFootball = retrofitFootball.create(ApiFootball::class.java)

        val callFootball = apiFootball.getAllCompetitors()
        callFootball.enqueue(object: Callback<Competition> {
            override fun onResponse(call: Call<Competition>, response: Response<Competition>?) {
                if (response != null) {
                    for (res in response.body().competitions) {
                        Log.d("TAG response: ", res.name)
                    }
                }
                if (response != null) {
                    binding.footballRecycler.adapter = FootballAdapter(response.body().competitions)
                }
            }

            override fun onFailure(call: Call<Competition>, t: Throwable?) {
                Log.e("TAG failure: ", t.toString())
            }

        })
    }
}
