package binar.academy.challenge_chapter3_intent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import binar.academy.challenge_chapter3_intent.R
import binar.academy.challenge_chapter3_intent.adapter.AlphabetAdapter
import binar.academy.challenge_chapter3_intent.databinding.FragmentAlphabetBinding
import binar.academy.challenge_chapter3_intent.model.Words

class AlphabetFragment : Fragment() {
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
            Words('K', arrayListOf("Kambing", "Kim Taehyung", "Kendal Jenner")),
            Words('L', arrayListOf("Lamp", "Loona", "Lizzo")),
            Words('M', arrayListOf("Monyet", "Madonna", "Mobile Legend")),
            Words('N', arrayListOf("New Jeans", "NCT", "Nicki Minaj")),
            Words('O', arrayListOf("Opor Ayam", "Olaf", "Onion")),
            Words('P', arrayListOf("Putri Salju", "Party", "Pink")),
            Words('Q', arrayListOf("Qatar", "Qiqi", "Queue")),
            Words('R', arrayListOf("Rambutan", "R&B", "Rotan")),
            Words('S', arrayListOf("STAYC", "Stray Kids", "Seventeen")),
            Words('T', arrayListOf("TXT", "Taehyun", "Taeyeon"))
        )

        val adapter = AlphabetAdapter(listAlphabets)
        val layoutManager = GridLayoutManager(context, 2)

        binding.rvAlphabet.adapter = adapter
        binding.rvAlphabet.layoutManager = layoutManager

        adapter.onClick = {
            val bundle = Bundle()
            bundle.putParcelable("datawords", it)

            val fragment = WordFragment()
            fragment.arguments = bundle

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}