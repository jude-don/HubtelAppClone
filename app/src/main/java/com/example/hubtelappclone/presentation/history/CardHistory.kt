package com.example.hubtelappclone.presentation.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hubtelappclone.R
import com.example.hubtelappclone.ui.theme.Typography
import com.example.hubtelappclone.ui.theme.accentTextColor
import com.example.hubtelappclone.ui.theme.mainBackgroundColor
import com.example.hubtelappclone.ui.theme.secondaryColor

@Composable
fun CardHistory(){
    Card( 
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = mainBackgroundColor,
        border = BorderStroke(dimensionResource(id = R.dimen.borderwidth), secondaryColor)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(dimensionResource(id = R.dimen.card_padding))
        ) {
            Text( 
                text = "14:45 PM",
                style = Typography.subtitle1.copy( 
                    color = accentTextColor
                )
            )
            
        }
        
    }
}

@Preview(showBackground = true)
@Composable 
fun MainCardInfo(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image( 
            painter = painterResource(id = R.drawable.mtn_icon), 
            contentDescription ="",
            modifier = Modifier.size(dimensionResource(id = R.dimen.logo_size))
        )
        
    }
}