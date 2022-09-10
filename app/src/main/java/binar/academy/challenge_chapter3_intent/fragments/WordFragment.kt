package binar.academy.challenge_chapter3_intent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import binar.academy.challenge_chapter3_intent.R
import binar.academy.challenge_chapter3_intent.adapter.WordsAdapter
import binar.academy.challenge_chapter3_intent.databinding.FragmentWordBinding
import binar.academy.challenge_chapter3_intent.model.Words

class WordFragment : Fragment() {
    private var _binding : FragmentWordBinding? = null
    private val  binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivBackWords.setOnClickListener {
            val fragment = parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AlphabetFragment())
                .commit()
        }

        val getData = this.arguments?.getParcelable<Words>("datawords") as Words

        binding.tvHeadWords.text = "Words That Start With ${getData.alphabets}"
        var adapter = getData.keywords?.let { WordsAdapter(it) }
        val layoutManager = GridLayoutManager(context, 2)

        binding.rvWords.adapter = adapter
        binding.rvWords.layoutManager = layoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}