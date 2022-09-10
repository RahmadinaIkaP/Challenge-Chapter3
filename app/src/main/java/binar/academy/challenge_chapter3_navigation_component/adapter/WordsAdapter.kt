package binar.academy.challenge_chapter3_navigation_component.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.challenge_chapter3_navigation_component.databinding.ItemWordsBinding

class WordsAdapter(private val listWords : ArrayList<String>) : RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemWordsBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(words: String){
            binding.tvAlphabet.text = words
            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$words"))
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemWordsBinding.inflate(LayoutInflater
            .from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val words = listWords[position]
        holder.bind(words)
    }

    override fun getItemCount() = listWords.size

}