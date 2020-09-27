package com.example.ejerciciocompilado21sept.model.ViewModel

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejerciciocompilado21sept.R
import com.example.ejerciciocompilado21sept.model.Room.ListDog
import java.text.FieldPosition
import javax.security.auth.callback.Callback

class DogAdapter(val callback: CallbackInterface): RecyclerView.Adapter<DogAdapter.DoginViewHolder>() {

    private var doglist = emptyList<ListDog>()

    fun updateAdapte(mList: List<ListDog>) {
        doglist = mList
        notifyDataSetChanged()
    }

    inner class DoginViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemtext = itemView.setOnClickListener {
            callback.passTheData(doglist[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): DoginViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item_list,parent,false)
        return DoginViewHolder()
    }

    override fun onBindViewHolder(holder: DoginViewHolder,position: Int) {
        Glide.with(holder.itemView.context).load(doglist[position].listDog).into(holder.itemtext)


    }

override fun getItemCount() = doglist.size

    interface CallbackInterface {
        fun passTheData(listDog: ListDog)
    }





}












