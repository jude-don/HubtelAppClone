package com.example.hubtelappclone.presentation.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.hubtelappclone.R
import com.example.hubtelappclone.navigation.History
import com.example.hubtelappclone.presentation.history.TopBar
import com.example.hubtelappclone.ui.theme.Typography
import com.example.hubtelappclone.ui.theme.floatActionBackgroundColor
import com.example.hubtelappclone.ui.theme.mainBackgroundColor


@Composable
fun HistoryPage(){

    Scaffold(
        topBar = {
            TopBar()
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
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
//                LazyColumn (
//                ){ items(){
//                        MoreElement -> (element = MoreElement)
//                }
//
//                }

                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    backgroundColor = floatActionBackgroundColor,
                    contentColor = Color.White,
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.BottomCenter),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.small_radius))
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription ="Make New Transaction",
                        tint = Color.White,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.addbutton_size))
                    )
                    Text(
                        text = "SEND NEW",
                        style = Typography.h3.copy(color = Color.White)
                    )

                }
            }

        }

    }
}



@Composable
fun UpperSection(){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()) {


    }
}