package com.example.hw_7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_7.databinding.FragmentFirstBinding
import com.example.hw_7.databinding.ItemComicsBinding

class AdapterComics (private var comicsList: ArrayList<Comics>, private var onItemClick: onItemClick): RecyclerView.Adapter<AdapterComics.ComicsViewHolder>()  {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder(
            ItemComicsBinding.inflate(LayoutInflater.from(parent.context))
        )
    }
    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(comicsList[position])
        holder.itemView.setOnClickListener{
            onItemClick.inItemClick(comicsList[position])
        }

        }
    override fun getItemCount(): Int {
       return comicsList.size
    }
   inner class ComicsViewHolder(private var binding: ItemComicsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(comics: Comics){
            binding.image.setImageResource(comics.img)
            binding.tvTv1.text=comics.name
            binding.tvTv2.text=comics.status
        }

        }
    }


