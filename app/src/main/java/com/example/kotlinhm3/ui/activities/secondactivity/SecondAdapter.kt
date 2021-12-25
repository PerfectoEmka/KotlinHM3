package com.example.kotlinhm3.ui.activities.secondactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhm3.databinding.ListItemBinding
import com.example.kotlinhm3.extensions.load
import com.example.kotlinhm3.models.Pictures

class SecondAdapter(private var list: ArrayList<Pictures>)
    : RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.onBind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun onBind(pictures: Pictures) {
            binding.ivPictures.load(pictures.url)
        }
    }
}