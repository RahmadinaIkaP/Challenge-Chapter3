package binar.academy.challenge_chapter3_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import binar.academy.challenge_chapter3_intent.databinding.ActivityMainBinding
import binar.academy.challenge_chapter3_intent.fragments.AlphabetFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, AlphabetFragment())
            .commit()
    }
}