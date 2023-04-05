package com.example.hubtelappclone.presentation.history

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hubtelappclone.R
import com.example.hubtelappclone.historymodel.HistoryViewModel
import com.example.hubtelappclone.historymodel.historyDataContainer
import com.example.hubtelappclone.ui.theme.*


// Main Composable
@Composable
fun HistorySubpage( onItemClick:(id:Int)->Unit ){
    val viewModel:HistoryViewModel = viewModel()
    val textState = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val context = LocalContext.current

    //Main layout for the History Subpage
    Column(
        modifier = Modifier.
        fillMaxSize()
    ) {
        UpperSection(state = textState, context = context, onChanged = viewModel.searchInputChanged)
        Spacer(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.extraLarge_spacer))
        )
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            // Lazy List for the Card and Date Composable
            LazyColumn{
                items( viewModel.getList()) {
                    HistoryDataContainer -> Column {
                    DateLazyList(historydata = HistoryDataContainer.Date)

                    for (item in HistoryDataContainer.historyDataList){
                        CardHistoryLazyColumn(history = item, onItemClick = { id -> onItemClick(id) })
                    }
                }
                }
            }

            //Floating Action Button component
            ExtendedFloatingActionButton(
                text = {
                    Text(
                        text = "SEND NEW",
                        style = Typography.h3.copy(color = Color.White)
                    ) },
                elevation = FloatingActionButtonDefaults.elevation(dimensionResource(id = R.dimen.floating_action_elevation)),
                onClick = {
                    Toast.makeText(context,"Page Under Construction",Toast.LENGTH_SHORT).show()
                          },
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

//Upper Section Composable which hold Searchbar and filtericon
@Composable
fun UpperSection(state: MutableState<TextFieldValue>, context: Context, onChanged:(input:String)->Unit){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()) {
        SearchBar(state = state) { input -> onChanged(input) }
        Spacer(modifier = Modifier
            .width(
                dimensionResource(
                    id = R.dimen.medium_spacer
                )
            )
        )

        //Filter icon
        Image(
            painter = painterResource(id = R.drawable.filter_icon),
            contentDescription ="filter icon",
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.filter_icon_size))
                .weight(0.1f)
                .clickable {
                    Toast
                        .makeText(context, "Filter page under construction", Toast.LENGTH_SHORT)
                        .show()
                }
        )
    }
}


// SearchBar Composable
@Composable
fun SearchBar(state: MutableState<TextFieldValue>,onChanged: (input: String) -> Unit){
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = state.value,
        onValueChange = {
            onChanged
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
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        )
    )

}



// Date Composable
@Composable
fun DateLazyList(historydata: String){
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
            text = historydata ,
            style = Typography.caption.copy(color = accentTextColor),
        )
    }
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.semiLarge_spacer)))
}


