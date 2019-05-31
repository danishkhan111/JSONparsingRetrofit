package com.example.admin.json_listview_retrofit.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.admin.json_listview_retrofit.R
import com.example.admin.json_listview_retrofit.model.response.Data
import com.example.admin.json_listview_retrofit.model.response.SimPrice

class JsonAdapter(var context: Context, var listItems: List<SimPrice?>, var citiesListItems: List<String?>) : RecyclerView.Adapter<JsonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JsonAdapter.ViewHolder {
        val context: Context = parent.context
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(R.layout.retro_lv, parent, false)

        // return a new holder instannce
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: JsonAdapter.ViewHolder, position: Int) {
        holder.bindItems(listItems.get(position)!!, citiesListItems.get(position)!!)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(simpricing: SimPrice, citiesListItems: String) {
            val price = itemView.findViewById(R.id.price) as TextView
            val deliveryCharges = itemView.findViewById(R.id.delivery_charges) as TextView
            val type = itemView.findViewById(R.id.type) as TextView
            val cities = itemView.findViewById(R.id.city) as TextView

            val citiesList: Data? = null

            price.text = simpricing.price
            deliveryCharges.text = simpricing.deliveryCharges
            type.text = simpricing.type
//            cities.text = citiesListItems.get(0).toString()
            cities.text = citiesListItems

//            var pointValue = StringBuilder()
//            for (i in 0 until citiesListItems!!.length) {
//
//                pointValue.append("\n" + citiesListItems!!.get(i).toString())
////                            tvMain.text = pointValue
//                cities.text = pointValue
//
//            }

        }

    }
}