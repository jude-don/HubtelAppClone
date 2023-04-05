package com.example.hubtelappclone.historymodel

import com.example.hubtelappclone.R



data class HistoryData(
    val id:Int,
    val recipientname:String,
    val phonenumber:String,
    val amount:String,
    val status:String,
    val image:Int

)

val historyData = listOf<HistoryData>(
    HistoryData(10,"Emmanuel Rockson","024 123 4557", "GHS 500","Successful",R.drawable.mtn_icon,),
    HistoryData(11,"Kojo Slim","024 123 4557", "GHS 200","Failed",R.drawable.absa,),
    HistoryData(12,"Emmanuel Rockson","024 123 4557", "GHS 5000","Successful",R.drawable.mtn_icon,),
    HistoryData(13,"Eunice Linger","024 123 4557", "GHS 300","Successful",R.drawable.absa,),
)
val historyData2 = listOf<HistoryData>(
    HistoryData(14,"Emmanuel Rockson","024 123 4557", "GHS 800","Failed",R.drawable.absa,),
    HistoryData(15,"Kojo Slim","024 123 4557", "GHS 300","Failed",R.drawable.absa,),
    HistoryData(16,"Emmanuel Rockson","024 123 4557", "GHS 5000","Failed",R.drawable.absa,),
    HistoryData(17,"Eunice Linger","024 123 4557", "GHS 100","Failed",R.drawable.absa,),
)
val historyData3 = listOf<HistoryData>(
    HistoryData(18,"Emmanuel Rockson","024 123 4557", "GHS 200","Successful",R.drawable.absa,),
    HistoryData(19,"Kojo Slim","024 123 4557", "GHS 900","Successful",R.drawable.mtn_icon,),
    HistoryData(20,"Emmanuel Rockson","024 123 4557", "GHS 8000","Successful",R.drawable.mtn_icon,),
    HistoryData(21,"Eunice Linger","024 123 4557", "GHS 400","Successful",R.drawable.absa,),
)

data class HistoryDataContainer(
    val Date:String,
    val historyDataList:List<HistoryData>
)

val historyDataContainer = listOf<HistoryDataContainer>(
    HistoryDataContainer("May 23, 2023", historyData),
    HistoryDataContainer("May 10, 2023", historyData2),
    HistoryDataContainer("May 10, 2023", historyData3)
)