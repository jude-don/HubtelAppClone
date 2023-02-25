package com.example.hubtelappclone.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hubtelappclone.R

// Set of the font types
val NunitoSansRegular = FontFamily(Font(R.font.nunitosans_regular))
val NunitoSansExtraBold = FontFamily(Font(R.font.nunitosans_extrabold))


// Set of Material typography styles to start with
val Typography = Typography(
    h3 = TextStyle(
        fontFamily = NunitoSansExtraBold,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = primaryTextColor
    ),
    body1 = TextStyle(
        fontFamily = NunitoSansRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = primaryTextColor
    ),
    subtitle1 = TextStyle(
        fontFamily = NunitoSansRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = primaryTextColor
    ),
    caption = TextStyle(
        fontFamily = NunitoSansExtraBold,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)