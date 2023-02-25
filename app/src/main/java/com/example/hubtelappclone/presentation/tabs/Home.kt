package com.example.hubtelappclone.presentation.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.hubtelappclone.ui.theme.mainBackgroundColor


@Composable
fun HomePage(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(mainBackgroundColor)
            .fillMaxSize()
    ) {
        Text(
            text = "This is the Home Page",
            fontSize = 30.sp
        )

    }
}