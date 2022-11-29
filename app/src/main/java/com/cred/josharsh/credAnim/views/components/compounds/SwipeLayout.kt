package com.cred.josharsh.credAnim.views.components.compounds

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.compose.rememberNavController
import com.cred.josharsh.credAnim.viewModels.SwipeAnimationViewModel
import com.cred.josharsh.credAnim.views.components.atoms.WhiteBox

@Composable
fun SwipeLayout(viewModel: SwipeAnimationViewModel) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box(
        ) {
            WhiteBox()
            Row(
                modifier = Modifier
                    .padding(top = screenHeight / 2.3f)
                    .align(Alignment.BottomCenter)
            ) {
               SwipeDownInteraction(viewModel)

            }
        }
    }
}