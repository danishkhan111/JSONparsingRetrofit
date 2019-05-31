    package com.example.admin.json_listview_retrofit

    import android.content.Context
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.BaseAdapter
    import android.widget.ImageView
    import android.widget.TextView
    import kotlin.collections.ArrayList

    class RetroAdapter(private val context: Context, private val dataModelArrayList: ArrayList<String>) : BaseAdapter() {

        override fun getViewTypeCount(): Int {
            return count
        }

        override fun getItemViewType(position: Int): Int {

            return position
        }

        override fun getCount(): Int {
            return dataModelArrayList.size

        }

        override fun getItem(position: Int): Any {
            return dataModelArrayList[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView = convertView
            val holder: ViewHolder

            if (convertView == null) {
                holder = ViewHolder()
                val inflater = context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                convertView = inflater.inflate(R.layout.retro_lv, null, true)

                var dataOne = dataModelArrayList?.get(0)

//                holder.tvname = convertView.findViewById<View>(R.id.name) as TextView
//                holder.tvcountry = convertView.findViewById<View>(R.id.country) as TextView
//                holder.tvcity = convertView.findViewById<View>(R.id.city) as TextView

                convertView.tag = holder
            } else {
                // the getTag returns the viewHolder object set as a tag to the view
                holder = convertView.tag as ViewHolder
            }


//            holder.tvname!!.text = "NAME: " + dataModelArrayList[position].type!!
//            holder.tvcountry!!.text = "COUNTRY: " + dataModelArrayList[position].price!!
//            holder.tvcity!!.text = "CITY: " + dataModelArrayList[position].deliveryCharges!!
            val tName = dataModelArrayList.get(0)
            holder.tvname!!.text = tName

            return convertView!!
        }

        private inner class ViewHolder {

            var tvname: TextView? = null
            var tvcountry: TextView? = null
            var tvcity: TextView? = null
            var iv: ImageView? = null
        }

    }
