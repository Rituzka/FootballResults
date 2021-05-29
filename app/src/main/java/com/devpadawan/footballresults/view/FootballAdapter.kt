package com.devpadawan.footballresults.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpadawan.footballresults.databinding.ItemFootballBinding
import com.devpadawan.footballresults.model.Area


class FootballAdapter(private val competition: ArrayList<Area>):
    RecyclerView.Adapter<FootballAdapter.FootballViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder {
        val binding = ItemFootballBinding
        .inflate(LayoutInflater.from(parent.context), parent, false)
        return FootballViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        val itemFootball = competition[position]
         holder.bindFootball(itemFootball)
    }

    override fun getItemCount(): Int {
        return competition.size
    }

    class FootballViewHolder(private val binding: ItemFootballBinding): RecyclerView.ViewHolder(binding.root){
        fun bindFootball(area: Area){
            binding.txtNumber.text = area.id.toString()
            binding.txtCountryCode.text = area.countryCode
            binding.txtName.text = area.name

        }
    }
}