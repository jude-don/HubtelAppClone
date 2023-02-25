package com.example.hubtelappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hubtelappclone.navigation.*
import com.example.hubtelappclone.presentation.tabs.HistoryPage
import com.example.hubtelappclone.presentation.tabs.HomePage
import com.example.hubtelappclone.presentation.tabs.SchedulePage
import com.example.hubtelappclone.presentation.tabs.SendPage
import com.example.hubtelappclone.ui.theme.HubtelAppCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()

        }
    }
}


@Composable
fun MainActivityContent(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar ={
            BottomNavBar(navController = navController)
        }
    ) {
        Box(modifier = Modifier.padding(it)){
            NavHost(navController = navController, startDestination = Home.route ){

                composable(Home.route)
                {
                    HomePage()
                }
                composable(Send.route)
                {
                    SendPage()
                }
                composable(History.route)
                {
                    HistoryPage()
                }
                composable(Scheduled.route)
                {
                    SchedulePage()
                }
            }


        }



    }
}
