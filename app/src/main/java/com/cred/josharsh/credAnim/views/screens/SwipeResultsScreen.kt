package com.cred.josharsh.credAnim.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cred.josharsh.credAnim.ui.theme.Primary
import com.cred.josharsh.credAnim.views.components.atoms.WhiteBox

@Composable
fun SwipeResultsScreen(navController: NavController, resultMessage: String) {
    ContentView(navController, resultMessage)
}

@Composable
private fun ContentView(navController: NavController, resultMessage: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
    ) {
        SwipeResults(resultMessage)
    }
}

@Composable
private fun SwipeResults(resultMessage: String) {
    Box(
        contentAlignment = Alignment.TopStart
    ) {
        WhiteBox(resultMessage)
    }
}