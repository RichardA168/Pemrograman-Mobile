package com.example.dessertslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class DrinkAdapter(private val drinkLists : ArrayList<drink>) :
    RecyclerView.Adapter<DrinkAdapter.MyViewHolder>() {

    private lateinit var nListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        nListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate((R.layout.helper2),parent,false)
        return MyViewHolder(itemView,nListener)}

    override fun getItemCount(): Int {

        return drinkLists.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = drinkLists[position]
        holder.titleImage2.setImageResource(currentItem.image2)
        holder.heading2.text = currentItem.heading2
        holder.subheading2.text = currentItem.subheading2



    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){


        val titleImage2 : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val heading2: TextView = itemView.findViewById(R.id.heading)
        val subheading2: TextView = itemView.findViewById(R.id.subheading)




        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }
}