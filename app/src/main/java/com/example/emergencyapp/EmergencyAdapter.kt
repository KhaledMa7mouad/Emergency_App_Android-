package com.example.emergencyapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class EmergencyAdapter(val activity: Activity, val emergencies: ArrayList<EmergencyModel>) :
    RecyclerView.Adapter<EmergencyAdapter.MVH>() {

    class MVH(view: View) : RecyclerView.ViewHolder(view) {

        val parent: CardView = view.findViewById(R.id.parent)
        val iv: ImageView = view.findViewById(R.id.image)
        val tv: TextView = view.findViewById(R.id.tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmergencyAdapter.MVH {
        val view = activity.layoutInflater.inflate(R.layout.emergrncy_list_item, parent, false)
        return MVH(view)
    }

    override fun getItemCount() = emergencies.size

    override fun onBindViewHolder(holder: MVH, position: Int) {
        holder.iv.setImageResource(emergencies[position].pic)
        holder.tv.text = emergencies[position].name
        holder.parent.setOnClickListener {
            val i = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${emergencies[position].number}"))
            activity.startActivity(i)
        }
    }
}
