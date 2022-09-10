package binar.academy.challenge_chapter3_intent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.challenge_chapter3_intent.databinding.ItemWordsBinding
import binar.academy.challenge_chapter3_intent.model.Words

class AlphabetAdapter(private val listAlphabets : List<Words>)
    : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {

    var onClick : ((Words) -> Unit)? = null

    inner class ViewHolder(private val binding: ItemWordsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(words: Words){
            binding.tvAlphabet.text = words.alphabets.toString()
            itemView.setOnClickListener {
                onClick?.invoke(words)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemWordsBinding.inflate(LayoutInflater
            .from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alphabet = listAlphabets[position]
        holder.bind(alphabet)
    }

    override fun getItemCount() = listAlphabets.size
}