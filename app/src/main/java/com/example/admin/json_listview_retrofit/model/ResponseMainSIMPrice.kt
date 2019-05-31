package com.example.admin.json_listview_retrofit.model

import com.example.admin.json_listview_retrofit.model.response.Data
import org.json.JSONObject

data class ResponseMainSIMPrice(var resultCode: String,
                                var msg: String,
                                var execTime: String,
                                var data:Data)




