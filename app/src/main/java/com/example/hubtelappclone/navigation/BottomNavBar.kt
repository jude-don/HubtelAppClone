package com.example.hubtelappclone.navigation

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun BottomNavBar(navController: NavController){
    val destinationList = listOf<Route>(
        Home,
        Send,
        History,
        Scheduled
    )
    var selectedIndex by rememberSaveable{
        mutableStateOf(0)
    }
    BottomNavigation() {
        destinationList.forEachIndexed{
                index, route ->  BottomNavigationItem(
            label = { Text(text = route.title)},
            icon = { Image(painter = painterResource(id = route.icon),
                contentDescription = route.title)
            },
            selected =  index == selectedIndex,
            onClick = {
                selectedIndex = index
                navController.navigate(destinationList[index].route){
                    popUpTo(Home.route) //this removes everything from stack to the homescreen
                    launchSingleTop =true //this prevents adding the same screen more than once
                }
            }
        )
        }

    }

}