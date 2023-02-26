package com.example.hubtelappclone.presentation.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hubtelappclone.R
import com.example.hubtelappclone.navigation.History
import com.example.hubtelappclone.presentation.history.CardHistory
import com.example.hubtelappclone.presentation.history.TopBar
import com.example.hubtelappclone.ui.theme.*


@Composable
fun HistoryPage(){
    val textState = remember {
        mutableStateOf(TextFieldValue(""))
    }

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
            UpperSection(state = textState)
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.extraLarge_spacer))
            )
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    repeat(10){
                        Date()
                        CardHistory()
                        CardHistory()
                    }


                }
                ExtendedFloatingActionButton(
                    text = {
                        Text(
                            text = "SEND NEW",
                            style = Typography.h3.copy(color = Color.White)
                        ) },
                    elevation = FloatingActionButtonDefaults.elevation(dimensionResource(id = R.dimen.floating_action_elevation)),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.small_radius)),
                    backgroundColor = floatActionBackgroundColor,
                    contentColor = Color.White,
                    icon = {
                        Icon(
                            imageVector =Icons.Filled.AddCircle ,
                            contentDescription ="Send new",
                            tint = Color.White,
                            modifier = Modifier.size(dimensionResource(id = R.dimen.addbutton_size))
                        )
                    },
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.BottomCenter)
                )

            }

        }

    }
}



@Composable
fun UpperSection(state:MutableState<TextFieldValue>){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        SearchBar(state = state)
        Spacer(modifier = Modifier
            .width(
                dimensionResource(
                    id = R.dimen.medium_spacer
                )
            )
        )
        Image(
            painter = painterResource(id = R.drawable.filter_icon),
            contentDescription ="filter icon",
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.filter_icon_size))
                .weight(0.1f)
        )



    }
}

@Composable
fun SearchBar(state:MutableState<TextFieldValue>){
    OutlinedTextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = secondaryColor,
            unfocusedBorderColor = secondaryColor,
            focusedBorderColor = secondaryColor
        ), shape = RoundedCornerShape(dimensionResource(id = R.dimen.small_radius)),
        modifier = Modifier
            .fillMaxWidth(0.9f),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription ="Seearch Icon",
                tint = iconsColor,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.search_icon_size))
                    .padding(start = dimensionResource(id = R.dimen.icon_padding_start))
            )
        },
        placeholder = {
            Text(
                text = "Search",
                color = accentTextColor
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
    )

}

@Composable
fun Date(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.largest_spacer)))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentSize()
            .clip(
                RoundedCornerShape(dimensionResource(id = R.dimen.large_radius))
            )
            .background(
                color = secondaryColor
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
        Text(
            text = "May 24,2022",
            style = Typography.caption.copy(color = accentTextColor),
            )
    }
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.semiLarge_spacer)))
}









//@Preview(showBackground = true)
@Composable
fun MyPreview(){
    val textState = remember {
        mutableStateOf(TextFieldValue(""))
    }
   UpperSection(state = textState)
}