package binar.academy.challenge_chapter3_navigation_component.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.challenge_chapter3_navigation_component.R
import binar.academy.challenge_chapter3_navigation_component.adapter.WordsAdapter
import binar.academy.challenge_chapter3_navigation_component.databinding.FragmentWordsBinding

class WordsFragment : Fragment() {
    private var _binding : FragmentWordsBinding? = null
    private val binding get() = _binding!!
    private val args : WordsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackWords.setOnClickListener {
            Navigation.findNavController(view).navigateUp()
        }

        val words = args.datawords

        val adapter = WordsAdapter(words?.keywords!!)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.tvWords.text = "Words That Start With ${words.alphabets}"
        binding.rvWords.adapter = adapter
        binding.rvWords.layoutManager = layoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}