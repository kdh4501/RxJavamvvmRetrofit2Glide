package com.example.mvvmexam.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmexam.R
import com.example.mvvmexam.network.VolumeInfo

class BookListAdapter: RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {

    var bookListData = ArrayList<VolumeInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(bookListData[position])
    }

    override fun getItemCount(): Int {
        Log.d("dhkim", "bookListData.size : " + bookListData.size)
        return bookListData.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvTitle : TextView = view.findViewById(R.id.tvTitle)
        val tvPublisher : TextView = view.findViewById(R.id.tvPublisher)
        val tvDescription : TextView = view.findViewById(R.id.tvDescription)
        val thumbImageView : ImageView = view.findViewById(R.id.thumbImageView)

        fun bind(data : VolumeInfo){
            tvTitle.text = data.volumeInfo.title
            tvPublisher.text = data.volumeInfo.publisher
            tvDescription.text = data.volumeInfo.description
            Log.d("dhkim", "data.volumeInfo.title : " + data.volumeInfo.title)
            val url = data.volumeInfo?.imageLinks?.smallThumbnail
            Glide.with(thumbImageView)
                .load(url)
                .circleCrop()
                .into(thumbImageView)
        }
    }
}