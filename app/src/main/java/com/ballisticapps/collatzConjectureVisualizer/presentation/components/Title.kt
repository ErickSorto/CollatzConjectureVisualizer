package com.ballisticapps.collatzConjectureVisualizer.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(
    title: String
) {
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        style = TextStyle(
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        ),
        color = textColor,
        textAlign = TextAlign.Center
    )
}