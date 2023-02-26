package com.example.hubtelappclone.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.hubtelappclone.ui.theme.Typography
import com.example.hubtelappclone.ui.theme.accentTextColor
import com.example.hubtelappclone.ui.theme.primaryTextColor
import com.example.hubtelappclone.ui.theme.secondaryColor

@Composable
fun TopBar(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp)
            .background(Color.White)
            .padding(dimensionResource(id = com.example.hubtelappclone.R.dimen.segmented_control_padding))
    ) {
SegementControl()
    }
}


@Composable
fun SegementControl(){
    var index by rememberSaveable{ mutableStateOf(0) }
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(dimensionResource(id = com.example.hubtelappclone.R.dimen.small_radius))
            )
            .clip(RoundedCornerShape(dimensionResource(id = com.example.hubtelappclone.R.dimen.small_radius)))
        ,


        ) {
        Box(modifier = Modifier
            .weight(1f)
            .requiredHeight(35.dp)
            .background(
                color = if (index == 0) Color.White else secondaryColor
            )
            .clickable { index = 0 }

        ){
            Text(
                text ="History",
                color = if (index==0) primaryTextColor else accentTextColor,
                modifier = Modifier.align(Alignment.Center),
                style = if (index == 0) Typography.h2 else Typography.h1
            )
        }
        Box(modifier = Modifier
            .weight(1f)
            .requiredHeight(35.dp)
            .background(
                color = if (index == 1) Color.White else secondaryColor
            )
            .clickable { index = 1 }
        ){
            Text(
                "Transaction Summary",
                color= if(index==1) primaryTextColor else accentTextColor,
                modifier = Modifier.align(Alignment.Center),
                style = if (index == 0) Typography.h2 else Typography.h1
            )
        }
    }
}