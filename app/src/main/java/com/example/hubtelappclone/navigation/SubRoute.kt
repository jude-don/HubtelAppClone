package com.example.hubtelappclone.navigation

sealed interface SubRoute{
    val route: String
}

object HistorySubpage: SubRoute{
    override val route = "HistorySubpage"
}
object TransactionSummary: SubRoute{
    override val route = "TransactionSummary"
}