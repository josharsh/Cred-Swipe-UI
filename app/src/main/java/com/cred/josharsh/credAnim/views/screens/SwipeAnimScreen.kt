package com.cred.josharsh.credAnim.views.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavController
import com.cred.josharsh.credAnim.constants.ScreenTags
import com.cred.josharsh.credAnim.constants.States
import com.cred.josharsh.credAnim.ui.theme.Primary
import com.cred.josharsh.credAnim.viewModels.SwipeAnimationViewModel
import com.cred.josharsh.credAnim.views.components.atoms.Switcher
import com.cred.josharsh.credAnim.views.components.compounds.SwipeLayout

@Composable
fun SwipeAnimScreen(navController: NavController, viewModel: SwipeAnimationViewModel) {
    val context = LocalContext.current
    viewModel.shouldGetSwipeResult.observe(LocalLifecycleOwner.current) {
        if (it) {
            viewModel.getSwipeResult(viewModel.checkedState.value)
        }
    }
    viewModel.swipeResult.observe(LocalLifecycleOwner.current) { swipeResult ->
        swipeResult.let { result ->
            if (result?.success == true) {
                viewModel.setSwipeResultMessage(result.success!!)
                navController.navigate(ScreenTags.SwipeResultsScreen.tag)
            } else if (result?.success == false) {
                viewModel.setSwipeState(States.TOP)
                Toast.makeText(context, "Failure", Toast.LENGTH_LONG).show()
            }
        }
    }
    ContentView(viewModel)
}

@Composable
private fun ContentView(viewModel: SwipeAnimationViewModel) {
    Box(
        modifier = Modifier
            .background(Primary),
        contentAlignment = Alignment.TopStart
    ) {
        SwipeLayout(viewModel)
        Column(modifier = Modifier.align(Alignment.BottomStart)) {
            Switcher(viewModel.checkedState)
        }
    }

}