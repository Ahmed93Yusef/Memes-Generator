package com.example.memes_generator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.memes_generator.databinding.ActivityMainBinding
import okhttp3.Request

class MainActivity : AppCompatActivity() {
    private val items = listOf("10-Guy","1950s-Middle-Finger","1990s-First-World-Problems","1st-World-Canadian-Problems",
        "2nd-Term-Obama","Aaaaand-Its-Gone","Ace-Primo","Actual-Advice-Mallard","Adalia-Rose","Admiral-Ackbar-Relationship-Expert",
        "Advice-Dog","Advice-Doge","Advice-God","Advice-Peeta","Advice-Tam","Advice-Yoda","Afraid-To-Ask-Andy",
    "Afraid-To-Ask-Andy-Closeup","Aint-Nobody-Got-Time-For-That","Alan-Greenspan","Alarm-Clock","Albert-Cagestein",
    "Albert-Einstein-1","Alien-Meeting-Suggestion","Alright-Gentlemen-We-Need-A-New-Idea","Always-Has-Been")


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val url1 =  binding.topEditText.text.toString()
            val url2 =  binding.bottomEditText.text.toString()
            getUrl(url1,url2)
        }


    }

    private fun getUrl(url1: String , url2: String) {
        var url = items.random()
        var mUrl = "https://apimeme.com/meme?meme=${url}&top=${url1}&bottom=${url2}"
        loadImage(mUrl)
    }


    private fun loadImage(url: String) {
        Glide.with(this).load(url)
            .placeholder(R.drawable.ic_baseline_cloud_download_24)
            .error(R.drawable.ic_baseline_error)
            .into(binding.imageView)
    }
}