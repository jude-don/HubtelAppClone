package com.example.hubtelappclone.historymodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HistoryViewModel:ViewModel() {
    fun getList() = historyDataContainer
    var searchInput by mutableStateOf("")
    val searchInputChanged = { input:String -> searchInput = input }
}
