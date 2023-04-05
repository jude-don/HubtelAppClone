package com.example.hubtelappclone.presentation.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hubtelappclone.R
import com.example.hubtelappclone.historymodel.HistoryData
import com.example.hubtelappclone.historymodel.HistoryDetailViewModel
import com.example.hubtelappclone.ui.theme.Typography

@Composable
fun HistoryDetailScreen(){
val viewModel:HistoryDetailViewModel = viewModel()
    val state = viewModel.state
    if (state != null){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.main_horizontal_padding)
                )
        ) {
            DetailsHeader(history = state)
            DetailsBody(history = state)
            
        }
    }
}
@Composable
private fun DetailsHeader(history:HistoryData){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
        .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = history.image) , 
            contentDescription = "image",
            modifier = Modifier.wrapContentSize()
        )
        Spacer(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.extraLarge_spacer))
        )
        Text(
            text = history.recipientname,
            style = Typography.body1
        )
        Spacer(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.extraLarge_spacer))
        )
    }
}

@Composable
private fun DetailsBody(history: HistoryData){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Amount",
                style = Typography.subtitle1
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.semi_spacer))
            )
            Text(
                text = "Account Number",
                style = Typography.subtitle1
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.semi_spacer))
            )
            Text(
                text = "Status",
                style = Typography.subtitle1
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.semi_spacer))
            )
            Text(
                text = "Reference",
                style = Typography.subtitle1
            )
         
        }
        
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = history.amount,
                style = Typography.subtitle1
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.semi_spacer))
            )
            Text(
                text = history.phonenumber,
                style = Typography.subtitle1
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.semi_spacer))
            )
            Text(
                text = history.status,
                style = Typography.subtitle1
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.semi_spacer))
            )
            Text(
                text = "Personal",
                style = Typography.subtitle1
            )


        } 
    }
    
}