package com.example.admin.json_listview_retrofit

import com.example.admin.json_listview_retrofit.model.RequestSIMPrice
import com.example.admin.json_listview_retrofit.model.ResponseMainSIMPrice
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.*


interface NetworkService {

    @POST("getsimpricingapi/1.0.0/getsimpricing")
    @Headers("channel:android",
            "subtoken:NWczek1hWHZjdlJBODR0VXVXRlhNSkdTYXlFa1FadmZNQXp1ajdlSm93VmgyUWVrSVBuRlF5UFBTNkkycndFdkFvd0Vja0JadWFnR2lCb1hLOGV1SEE9PQ==",
            "language:1",
            "parentmsisdn:923000776089",
            "appversion:1.1.1",
            "type:postpaid",
            "deviceid:a6d31f207d71beb7",
            "token:WXI5YU9PQkMrMTZkOExwSEpQMnp5UXVPK2svLzQreHVqUUF3cnAzcCtRdlk5Vk42VzNyd1RJQnAvTmFTOTBrZA==",
            "network:jazz",
            "authorization:Bearer 4acfba95-6a60-3610-aa27-9950e17c8213",
            "customerId:611552",
            "content-type:application/json",
            "msisdn:923000776089")
    fun getSimPricing(@Body requestBody: RequestSIMPrice): Call<ResponseMainSIMPrice>
    val string: Call<String>

    companion object {

        val JSONURL = "http://119.73.65.154:8280/"
    }
}
