package com.cred.josharsh.credAnim.views.components.atoms

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomStyleText(text: String, color: Color, fontSize: TextUnit, textAlign: TextAlign) {
    Text(
        style = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold),
        color = color,
        fontSize = fontSize,
        textAlign = textAlign,
        text = text
    )
}