package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class MyAdapter constructor (private val getActivity: MainActivity, private val bookList: List<MyModel>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.title.text = bookList[position].title
        holder.no.text = bookList[position].no.toString()

        holder.cardView.setOnClickListener {
            val intent = Intent(getActivity, BookActivity::class.java )
            intent.putExtra("position", position)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            getActivity.startActivity(intent)
            Toast.makeText(getActivity, "Opened ${holder.title.text} ", Toast.LENGTH_SHORT).show()
        }


    }



    override fun getItemCount(): Int {
        return bookList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         val no : TextView = itemView.findViewById(R.id.chNo)
        val title : TextView = itemView.findViewById(R.id.chName)
        val cardView : CardView = itemView.findViewById(R.id.cardView)





    }



}