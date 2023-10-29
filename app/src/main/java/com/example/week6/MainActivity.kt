package com.example.week6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.week6.network.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private val apiService = RetroInstance.getRetroInstance().create(RetroService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        initRecyclerView()

        apiService.getData(1).enqueue(object : Callback<RickAndMorty> {
            override fun onResponse(call: Call<RickAndMorty>, response: Response<RickAndMorty>) {
                if (response.isSuccessful) {
                    val characterList = response.body()?.results ?: emptyList()
                    adapter.setCharacterList(characterList)
                }
            }

            override fun onFailure(call: Call<RickAndMorty>, t: Throwable) {
            }
        })
    }

    private fun initRecyclerView() {
        adapter = RecyclerViewAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
    }
}
