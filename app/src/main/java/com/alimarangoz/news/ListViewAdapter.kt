package com.alimarangoz.news

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ListViewAdapter(private val context: Activity, private val list: List<News>) : ArrayAdapter<News>(context, 0, list ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val item = list[position]

        Glide.with(context)
            .load(item.img)
            .into(holder.imageView)

        holder.textView.text = item.title

        return view!!
    }

    private class ViewHolder(view: View) {
        val imageView: ImageView = view.findViewById(R.id.image_view_id)
        val textView: TextView = view.findViewById(R.id.txt_view_id)
    }


}