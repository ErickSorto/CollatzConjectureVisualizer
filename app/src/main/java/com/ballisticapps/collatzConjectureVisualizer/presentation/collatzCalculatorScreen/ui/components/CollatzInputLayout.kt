package com.ballisticapps.collatzConjectureVisualizer.presentation.collatzCalculatorScreen.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ballisticapps.CollatzConjectureVisualizer.R

@Composable
fun CollatzInputLayout(
    collatzCalculatorEvent: (CollatzCalculatorEvent) -> Unit,
    enteredNumber: String,
    modifier: Modifier
) {

    val containerColor = colorResource(id = R.color.gray).copy(alpha = 0.2f)
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    TextField(
        value = enteredNumber,
        onValueChange = { collatzCalculatorEvent(CollatzCalculatorEvent.EnteredNumber(it)) },
        label = { Text("Enter Number (n)") },
        maxLines = Int.MAX_VALUE,
        textStyle = TextStyle(fontSize = 16.sp),
        trailingIcon = {
            Button(
                onClick = { collatzCalculatorEvent(CollatzCalculatorEvent.CalculateCollatzNumber) },
                colors = buttonColors(
                    containerColor = Color.Transparent,
                )
            ) {

                Text(
                    "Calculate",
                    color = textColor,
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedLabelColor = textColor,
            unfocusedLabelColor = textColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            cursorColor = textColor,
            focusedIndicatorColor = colorResource(id = R.color.teal_200),
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ),
        modifier = modifier.height(56.dp),
    )
}
