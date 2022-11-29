package com.cred.josharsh.credAnim.views.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cred.josharsh.credAnim.constants.ScreenTags
import com.cred.josharsh.credAnim.ui.theme.*
import com.cred.josharsh.credAnim.viewModels.SwipeAnimationViewModel
import com.cred.josharsh.credAnim.views.screens.SwipeAnimScreen
import com.cred.josharsh.credAnim.views.screens.SwipeResultsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SwipeAnimationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold() {
                ComposeTheme {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = ScreenTags.SwipeAnimScreen.tag) {
                        composable(ScreenTags.SwipeAnimScreen.tag) {
                            SwipeAnimScreen(
                                navController,
                                viewModel
                            )
                        }
                        composable(ScreenTags.SwipeResultsScreen.tag) {
                            viewModel.swipeResultMessage?.let { message ->
                                SwipeResultsScreen(
                                    navController,
                                    message
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ComposeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    CREDTheme(content = content)
}