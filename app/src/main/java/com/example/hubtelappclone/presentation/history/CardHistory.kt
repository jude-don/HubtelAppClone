package com.example.hubtelappclone.presentation.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hubtelappclone.R
import com.example.hubtelappclone.historymodel.HistoryData
import com.example.hubtelappclone.ui.theme.*

@Composable
fun CardHistoryLazyColumn(history: HistoryData,onItemClick:(id:Int)->Unit ){

    //Card layout
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onItemClick(history.id) },
        shape = RoundedCornerShape(
            dimensionResource(
                id = R.dimen.medium_radius
            )
        ),
        backgroundColor = mainBackgroundColor,
        border = BorderStroke(dimensionResource(id = R.dimen.borderwidth), secondaryColor)
    ) {

        //Main Layout within Card
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
            Spacer(
                modifier = Modifier
                    .height(
                        dimensionResource(
                            id = R.dimen.semi_spacer
                        )
                    )
            )
            MainCardInfo(history)

            Spacer(
                modifier = Modifier
                    .height(
                        dimensionResource(
                            id = R.dimen.semiLarge_spacer
                        )
                    )
            )
            Divider(
                color = secondaryColor,
                thickness = 1.dp
            )
            Spacer(
                modifier = Modifier
                    .height(
                        dimensionResource(
                            id = R.dimen.semiLarge_spacer
                        )
                    )
            )
            SubCardInfo()
        }
    }
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.semiLarge_spacer)))
}

// Card Information Composable containing Image, name, phonenumber, Status and Amount
@Composable
private fun MainCardInfo(history:HistoryData) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            painter = painterResource(history.image),
            contentDescription ="",
            modifier = Modifier
                .size(
                    dimensionResource(
                        id = R.dimen.logo_size
                    )
                )
        )
        Spacer(
            modifier = Modifier
                .width(
                    dimensionResource(
                        id = R.dimen.medium_spacer
                    )
                )
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .wrapContentHeight()
                .weight(0.5f)
        ) {
            Text(
                text = history.recipientname,
                style = Typography.body1
            )
            Spacer(
                modifier = Modifier
                    .height(
                        dimensionResource(
                            id = R.dimen.medium_spacer
                        )
                    ))
            Text(
                text = history.phonenumber,
                style = Typography.body1.copy(color = secondaryTextColor),
            )

        }
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .wrapContentSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .wrapContentSize()
                    .clip(
                        RoundedCornerShape(dimensionResource(id = R.dimen.large_radius))
                    )
                    .background(
                        color = if (history.status == "Successful")
                            successColor
                        else
                            failedColor
                    )
                    .padding(
                        vertical = dimensionResource(
                            id = R.dimen.container_vertical_padding
                        ),
                        horizontal = dimensionResource(
                            id = R.dimen.container_horizontal_padding
                        )
                    ),
            ){
                Image(
                    painter = painterResource(
                        id = if (history.status == "Successful")
                            R.drawable.check_icon
                            else
                                R.drawable.cross_icon
                    ),
                    contentDescription = history.status,
                    modifier = Modifier
                        .size(
                            dimensionResource(id = R.dimen.status_icon_size)
                        )

                )
                Spacer(
                    modifier = Modifier
                        .width(
                            dimensionResource(
                                id = R.dimen.small_spacer
                            )
                        )
                )
                Text(
                    text = history.status,
                    style = Typography.caption.copy(color = if (history.status == "Successful")
                        successTextColor
                    else
                        failedTextColor
                    ),
                    )
            }
            Spacer(
                modifier = Modifier
                    .height(
                        dimensionResource(
                            id = R.dimen.small_spacer
                        )
                    )
            )
            Text(
                text = history.amount,
                style = Typography.h3

            )
        }
    }
}


//Card Sub information composable containing User icon, Reason and Reference
@Composable
private fun SubCardInfo(){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.user_icon
            ),
            contentDescription = "User Icon",
            modifier = Modifier.size(dimensionResource(id = R.dimen.user_icon_size))
        )
        Spacer(
            modifier = Modifier
                .width(
                    dimensionResource(
                        id = R.dimen.medium_spacer
                    )
                )
        )
        Text(
            text = "Personal",
            style = Typography.subtitle1
        )
        Spacer(
            modifier = Modifier
                .width(
                    dimensionResource(
                        id = R.dimen.medium_spacer
                    )
                )
        )
        Image(
            painter = painterResource(
                id = R.drawable.baseline_circle_24
            ),
            contentDescription ="circle"
        )
        Spacer(
            modifier = Modifier
                .width(
                    dimensionResource(
                        id = R.dimen.medium_spacer
                    )
                )
        )
        Text(
            text = "Cool your heart wai",
            style = Typography.subtitle1
        )
    }
}


