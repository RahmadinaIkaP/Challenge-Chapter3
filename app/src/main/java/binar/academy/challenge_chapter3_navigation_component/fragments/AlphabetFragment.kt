package binar.academy.challenge_chapter3_navigation_component.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import binar.academy.challenge_chapter3_navigation_component.Words
import binar.academy.challenge_chapter3_navigation_component.adapter.AlphabetAdapter
import binar.academy.challenge_chapter3_navigation_component.databinding.FragmentAlphabetBinding

class AlphabetFragment : Fragment(), AlphabetAdapter.AlphabetInterface {
    private var _binding : FragmentAlphabetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlphabetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAlphabets = arrayListOf(
            Words('A', arrayListOf("Ayam", "Angklung", "Ambon")),
            Words('B', arrayListOf("Bandung", "Billie Eilish", "BTS")),
            Words('C', arrayListOf("Cicak", "California", "Choi Woo Sik")),
            Words('D', arrayListOf("Dadu", "Drake", "Diluc")),
            Words('E', arrayListOf("Elle Fanning", "Elang", "Enhypen")),
            Words('F', arrayListOf("Fatui", "Festival", "Flamingo")),
            Words('G', arrayListOf("Genshin", "G-Dragon", "Gojek")),
            Words('H', arrayListOf("Huening Kai", "Huening Bahiyyih", "Honey")),
            Words('I', arrayListOf("Ive", "Indonesia", "Instagram")),
            Words('J', arrayListOf("JK Rowling", "J-Hope", "Jembatan")),
        )

        val adapter = AlphabetAdapter(listAlphabets, this)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.rvAlphabet.adapter = adapter
        binding.rvAlphabet.layoutManager = layoutManager
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(words: Words) {
        val action = AlphabetFragmentDirections.actionAlphabetFragmentToWordsFragment(words)
        Navigation.findNavController(requireView()).navigate(action)
    }
}