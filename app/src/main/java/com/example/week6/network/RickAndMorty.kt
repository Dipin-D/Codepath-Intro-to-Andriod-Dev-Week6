package com.example.week6.network

data class RickAndMorty (val results: ArrayList<CharacterData>)
data class CharacterData(val name:String? , val species: String? , val image: String?, val gender: String?)