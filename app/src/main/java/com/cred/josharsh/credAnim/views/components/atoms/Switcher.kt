package com.cred.josharsh.credAnim.views.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Switcher(checkedState: MutableState<Boolean>) {
    Switch(
        modifier= Modifier.padding(start=10.dp),
        checked = checkedState.value,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            uncheckedThumbColor = Color.Red,
            checkedTrackColor = Color.White,
            uncheckedTrackColor = Color.White),
        onCheckedChange = { checkedState.value = it }
    )
}