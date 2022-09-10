package binar.academy.challenge_chapter3_navigation_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.challenge_chapter3_navigation_component.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}