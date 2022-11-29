package com.cred.josharsh.credAnim.views.components.atoms

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WhiteBox(message: String? = null) {
    val configuration = LocalConfiguration.current
    val localHeight = configuration.screenHeightDp.dp
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(localHeight / 2)
            .padding(start = 20.dp, top = 20.dp, end = 20.dp),
        shape = RoundedCornerShape(30.dp),
        backgroundColor = Color.White
    ) {
        Box(
            modifier = Modifier.padding(bottom = localHeight / 20),
            contentAlignment = Alignment.BottomCenter
        ) {
            message?.let {
                CustomStyleText(
                    color = Color.Black,
                    text = message,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}