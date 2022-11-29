package com.cred.josharsh.credAnim.views.components.atoms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cred.josharsh.credAnim.ui.theme.Primary
import com.cred.josharsh.credAnim.ui.theme.Primary_300
import com.cred.josharsh.credAnim.views.components.anim.LoadingAnimation
import com.cred.josharsh.credAnim.views.components.anim.Pulsating

@Composable
fun CircularHolder(loading: Boolean) {
    var visible by remember { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .height(120.dp)
            .width(120.dp)
            .padding(2.dp)
            .border(1.dp, Primary_300, shape = CircleShape),
        shape = RoundedCornerShape(100)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Primary)
        ) {
            if (loading)
                AnimatedVisibility(
                    visible = visible,
                    exit = shrinkVertically()
                ) {
                    Pulsating() {
                        LoadingAnimation()
                    }
                }
        }
    }

}


