package binar.academy.challenge_chapter3_navigation_component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.challenge_chapter3_navigation_component.Words
import binar.academy.challenge_chapter3_navigation_component.databinding.ItemWordsBinding

class AlphabetAdapter(private val listAlphabet : ArrayList<Words>,
                      private val onClick : AlphabetAdapter.AlphabetInterface )
    : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding : ItemWordsBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(words : Words){
            binding.tvAlphabet.text = words.alphabets.toString()
            itemView.setOnClickListener {
                onClick.onItemClick(words)
            }
        }
    }

    interface AlphabetInterface{
        fun onItemClick(words: Words)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemWordsBinding.inflate(LayoutInflater
            .from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alphabet = listAlphabet[position]
        holder.bind(alphabet)
    }

    override fun getItemCount() = listAlphabet.size
}