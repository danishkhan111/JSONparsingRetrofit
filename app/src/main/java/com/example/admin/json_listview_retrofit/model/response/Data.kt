package com.example.admin.json_listview_retrofit.model.response


data class Data(
        var simPricing: List<SimPrice>?=null,
        var points: List<String>? = null,
        var cityList: List<String>? = null)
data class SimPrice(var type:String,
                    var price:String,
                    var deliveryCharges:String)