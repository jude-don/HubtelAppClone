package com.example.hubtelappclone.historymodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.hubtelappclone.navigation.HistoryDetails

class HistoryDetailViewModel(
    private val stateHandle: SavedStateHandle
):ViewModel() {
    var state:HistoryData? by mutableStateOf(null)
        private set

init {
    val id = stateHandle.get<Int>(HistoryDetails.idarg)
    state = getHistoryData(id!!)
}


    fun getHistoryData(id:Int): HistoryData? {
        for (container in historyDataContainer){
            for (data in container.historyDataList){
                if (data.id == id){
                    return data
                }
            }
        }
        return null
    }

}