package com.example.week6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week6.network.CharacterData
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private var characterList: List<CharacterData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    fun setCharacterList(characterList: List<CharacterData>) {
        this.characterList = characterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = characterList[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: CharacterData) {
            val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
            val speciesTextView = itemView.findViewById<TextView>(R.id.speciesTextView)
            val genderTextView = itemView.findViewById<TextView>(R.id.genderTextView)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)

            nameTextView.text = character.name
            speciesTextView.text = character.species
            genderTextView.text = character.gender

            // Load image using Picasso
            Picasso.get().load(character.image).into(imageView)
        }
    }
}
