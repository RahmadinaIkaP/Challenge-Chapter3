package binar.academy.challenge_chapter3_navigation_component

import java.io.Serializable

data class Words(
    val alphabets : Char,
    val keywords : ArrayList<String>
) : Serializable
