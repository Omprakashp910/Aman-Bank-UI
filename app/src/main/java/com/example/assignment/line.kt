package com.example.assignment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color


@Composable
fun LineWithText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f).padding(18.dp)
                .height(1.dp),
            color = Color.Black
        )
        Text(
            text = "Or",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp),
            textAlign = TextAlign.Center
        )
        Divider(
            modifier = Modifier
                .weight(1f).padding(18.dp)
                .height(1.dp),
            color = Color.Black
        )
    }
}

@Composable
fun TextWithUnderline() {
    Box(
        modifier = Modifier
            .padding(bottom = 4.dp)
    ) {
        Box(modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(0.35f)
                .height(2.dp)
                .background(Color(0xFF003559))
                .padding(10.dp)
        )
    }
}



