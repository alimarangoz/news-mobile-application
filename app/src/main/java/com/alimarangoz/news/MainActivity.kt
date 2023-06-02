package com.alimarangoz.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_view_id)

        val result = ParseResult()
        val run = Runnable {
            val list = result.news()
            val items = mutableListOf<News>()

            runOnUiThread {
                listView.setOnItemClickListener { parent, view, position, id ->
                val element = parent.getItemAtPosition(position) // The item that was clicked
                val intent = Intent(this, WebActivity::class.java)
                intent.putExtra("href",list.get(position).href)
                startActivity(intent)
                }


            for (new in 0..list.size-1){
                items.add(News(list.get(new).title,list.get(new).img, list.get(new).href))

            }

            runOnUiThread {

                val adapter = ListViewAdapter(this,items)
                listView.adapter = adapter

                }

            }

        }
        Thread(run).start()





    }
}