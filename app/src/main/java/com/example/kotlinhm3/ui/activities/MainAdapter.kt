package com.example.kotlinhm3.ui.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinhm3.databinding.ListItemBinding
import com.example.kotlinhm3.extensions.load
import com.example.kotlinhm3.extensions.setVisibility
import com.example.kotlinhm3.models.Pictures

class MainAdapter(private var list: ArrayList<Pictures>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var onItemClick: ((Pictures) -> Unit)? = null

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

            binding.root.setOnClickListener {
                if (pictures.isSelected){
                    pictures.isSelected = false
                    binding.vTransp.setVisibility(false)
                } else {
                    binding.vTransp.setVisibility(true)
                    pictures.isSelected = true
                }
                onItemClick?.invoke(list[adapterPosition])
            }
        }
    }
}
