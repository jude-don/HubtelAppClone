package com.example.hubtelappclone.presentation.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hubtelappclone.R
import com.example.hubtelappclone.navigation.*
import com.example.hubtelappclone.presentation.history.HistoryDetailScreen
import com.example.hubtelappclone.presentation.history.HistorySubpage
import com.example.hubtelappclone.presentation.history.TopBar
import com.example.hubtelappclone.presentation.history.TransactionSummary
import com.example.hubtelappclone.ui.theme.*


@Composable
fun HistoryPage(){
    val sub_navController = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(sub_navController)
        }
    ) {
        Column(
            modifier = Modifier
                .background(mainBackgroundColor)
                .fillMaxSize()
                .padding(
                    start = dimensionResource(
                        id = R.dimen.main_horizontal_padding
                    ),
                    end = dimensionResource(
                        id = R.dimen.main_horizontal_padding
                    ),
                    top = dimensionResource(
                        id = R.dimen.mainpage_padding_top
                    ),
                    bottom = dimensionResource(
                        id = R.dimen.mainpage_padding_bottom
                    )
                )
                .padding(it)
        ) {

            //Navigation for the Segmented Control
            NavHost(navController = sub_navController, startDestination = HistorySubpage.route ){
                composable(HistorySubpage.route)
                {
                    HistorySubpage(){
                        id ->  sub_navController.navigate(HistoryDetails.route + "/$id")
                    }
                }
                composable(TransactionSummary.route)
                {
                   TransactionSummary()
                }
                composable(
                    route = HistoryDetails.route+"/{${HistoryDetails.idarg}}",
                    arguments = listOf(navArgument(HistoryDetails.idarg){
                        type = NavType.IntType
                    })
                ){
                    val id = it.arguments?.getInt(HistoryDetails.idarg)
                    HistoryDetailScreen()
                }
            }


        }

    }


}
