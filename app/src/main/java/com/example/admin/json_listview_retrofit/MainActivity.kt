package com.example.admin.json_listview_retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import com.example.admin.json_listview_retrofit.adapter.JsonAdapter
import com.example.admin.json_listview_retrofit.model.RequestSIMPrice
import com.example.admin.json_listview_retrofit.model.ResponseMainSIMPrice
import com.example.admin.json_listview_retrofit.model.response.Data
import com.example.admin.json_listview_retrofit.model.response.SimPrice
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    //    private var listView: ListView? =
    private var recylerview: RecyclerView? = null
    //    private var retroAdapter: RetroAdapter? = null
    private var jsonAdapter: JsonAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        listView = findViewById(R.id.lv)
        recylerview = findViewById(R.id.recylerview)
        recylerview?.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        // setting up the adapter
//        listView?.adapter = retroAdapter

        callATestApiRequestToGetSIMPricing()

    }

    private fun callATestApiRequestToGetSIMPricing() {

        val retrofit = Retrofit.Builder()
                .baseUrl(NetworkService.JSONURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val networkApi = retrofit.create(NetworkService::class.java)

        val requestBody = RequestSIMPrice("jazz", "1", "postpaid")

        networkApi.getSimPricing(requestBody).enqueue(object : Callback<ResponseMainSIMPrice> {
            override fun onFailure(call: Call<ResponseMainSIMPrice>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: " + t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponseMainSIMPrice>, response: Response<ResponseMainSIMPrice>) {


                Log.d("SS", response.toString())

                //Toast.makeText()
                if (response.isSuccessful) {
                    if (response.body() != null) {


                        val points = response.body()?.data?.cityList
                        val sim = response.body()?.data?.simPricing

                        val list = ArrayList<SimPrice>()
                        val citiesList = ArrayList<String>()

                        val firstCity = points?.get(0)
                        val secondCity = points?.get(1)
                        val thirdCity = points?.get(2)
                        val fouthCity = points?.get(3)
                        val fifthCity = points?.get(4)

//                        for (i in 0 until sim!!.size){
                        val first = sim?.get(0)
                        var delivery = first?.deliveryCharges
                        var prices = first?.price
                        var types = first?.type
//                        list.add(first!!)

                        // for second index
                        val second = sim?.get(1)
                        var second_deliveryCharges = second?.deliveryCharges
                        var second_price = second?.price
                        var second_types = second?.type

                        // for third index
                        val third = sim?.get(2)
                        var third_deliveryCharges = third?.deliveryCharges
                        var third_price = third?.price
                        var third_types = third?.type

                        // for fourth index
                        val fourth = sim?.get(3)
                        var fourth_deliveryCharges = fourth?.deliveryCharges
                        var fourth_price = fourth?.price
                        var fourth_types = fourth?.type

                        // for fifth index
//                        var fifth = sim?.get(4)
//                        var fifth_deliveryCharges = fifth?.deliveryCharges
//                        var fifth_price = fifth?.price
//                        var fifth_types = fifth?.type



                        list.add(first!!)
                        list.add(second!!)
                        list.add(third!!)
                        list.add(fourth!!)
//                        list.add(fifth!!)

                        citiesList.add(firstCity!!)
                        citiesList.add(secondCity!!)
                        citiesList.add(thirdCity!!)
                        citiesList.add(fouthCity!!)
                        citiesList.add(fifthCity!!)

                        val adapter = JsonAdapter(this@MainActivity, list, citiesList)
                        recylerview?.adapter = adapter
                        adapter.notifyDataSetChanged()


//                        recylerview?.adapter = jsonAdapter

//                        var deliveryChargesAt0 = simAtIndex0?.deliveryCharges
//                        var priceAt0 = simAtIndex0?.price
//                        var typeAt0 = simAtIndex0?.type

                        val simAtIndex1 = response.body()?.data?.simPricing?.get(1)

                        var deliveryChargesAt1 = simAtIndex1?.deliveryCharges
                        var price = simAtIndex1?.price
                        var type = simAtIndex1?.type
                        // Response

//                        tvMain.text=response.body()?.resultCode+ "\n"+ response.body()?.msg+"\n" +response.body()?.execTime+ "\n"+
//                                response.body()?.data?.points
                        var pointValue = StringBuilder()
                        for (i in 0 until points.size) {

//                            pointValue.append("\n" + points!!.get(i).toString())
////                            tvMain.text = pointValue

                        }


//                        Toast.makeText(applicationContext, "Response Received", Toast.LENGTH_LONG).show()
//                        writeListView(response)

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response")
                        Toast.makeText(applicationContext, "Nothing returned", Toast.LENGTH_LONG).show();
                    }
                }

            }

        })
    }


}


