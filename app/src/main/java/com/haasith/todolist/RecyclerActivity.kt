package com.haasith.todolist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_recycler.*
import okhttp3.*
import java.io.IOException

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val realm =  Realm.getDefaultInstance()
        val query = realm.where(ToDoItem::class.java)
        var result = query.findAll()

        var items = mutableListOf<ToDoItem>()
        for(r in result){
            items.add(r)
        }

        println("count " + items.count())
        fetchJson(this)

        recyclerView.layoutManager = LinearLayoutManager(this)


    }

    fun fetchJson(context: Context){

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()


        val client = OkHttpClient()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body()?.string()
                val gson= GsonBuilder().create()
                val homeFeed = gson.fromJson(body,HomeFeed::class.java)

                runOnUiThread{
                    println(body)
                    println(homeFeed)

                    println(homeFeed.video.get(0).name + "is count")

                    recyclerView.adapter = ToDoItemAdapter(context, homeFeed)
                }
            }

        })



    }
}

class HomeFeed(val video: List<Video>)

class Video(val name: String, val id: Int, val link:String, val imageURL:String, val numViews:String, val channel:Channel)

class Channel(val name: String, val profImage:String)
