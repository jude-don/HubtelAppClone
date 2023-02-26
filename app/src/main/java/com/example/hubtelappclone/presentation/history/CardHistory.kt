package com.example.hubtelappclone.presentation.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hubtelappclone.R
import com.example.hubtelappclone.ui.theme.*

@Composable
fun CardHistory(){
    Card( 
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(
            dimensionResource(
                id = R.dimen.medium_radius
            )
        ),
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
            Spacer(
                modifier = Modifier
                    .height(
                        dimensionResource(
                            id = R.dimen.semi_spacer
                        )
                    )
            )

            MainCardInfo()

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





@Composable 
fun MainCardInfo(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image( 
            painter = painterResource(id = R.drawable.mtn_icon), 
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
                )))

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .wrapContentHeight()
                .weight(0.5f)
            ) {
            Text(
                text = stringResource(id = R.string.Customer1Name),
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
                text = "024 123 4567",
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
                        color = successColor
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
                        id = R.drawable.check_icon
                    ),
                    contentDescription = "Successful",
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
                    text = "Successful",
                    style = Typography.caption.copy(color = successTextColor),

                )
            }
            Spacer(
                modifier = Modifier
                    .height(
                        dimensionResource(
                        id = R.dimen.small_spacer
                        )
                    ))
            Text(
                text = "GHS 500",
                style = Typography.h3

            )


        }
        
    }
}


@Composable
fun SubCardInfo(){
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


//@Preview (showBackground = true)
@Composable
fun PreviewFunction(){
    CardHistory()
}