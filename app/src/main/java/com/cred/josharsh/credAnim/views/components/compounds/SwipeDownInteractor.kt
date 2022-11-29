package com.cred.josharsh.credAnim.views.components.compounds

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.cred.josharsh.credAnim.constants.States
import com.cred.josharsh.credAnim.viewModels.SwipeAnimationViewModel
import com.cred.josharsh.credAnim.views.components.atoms.CircularHolder
import com.cred.josharsh.credAnim.views.components.atoms.SwipeDownIcon

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeDownInteraction(viewModel: SwipeAnimationViewModel) {
    var swipeLayoutHeight by remember { mutableStateOf(0.dp) }
    var swipeLayoutComponentsHeight by remember { mutableStateOf(1.dp) }
    val swipeState = rememberSwipeableState(viewModel.swipeState.value)
    var swipeSize by remember {
        mutableStateOf(1f)
    }

    if (swipeState.isAnimationRunning) {
        DisposableEffect(Unit) {
            onDispose {
                if (viewModel.loading.value) swipeState.performDrag(-1000f)
                when (swipeState.currentValue) {
                    States.TOP -> viewModel.setSwipeState(States.TOP)
                    States.BOTTOM -> {
                        viewModel.setSwipeState(States.BOTTOM)
                    }
                }
            }
        }
    }

    var swipeModifier: Modifier = Modifier
        .swipeable(
            state = swipeState,
            anchors = mapOf(
                0f to States.TOP,
                (swipeLayoutComponentsHeight.value) to States.BOTTOM,
            ),
            thresholds = { _, _ -> FractionalThreshold(0.9f) },
            orientation = Orientation.Vertical
        )
        .offset {
            IntOffset(0, swipeState.offset.value.toInt())
        }

    Box(
        modifier = Modifier.fillMaxHeight()
    ) {
        swipeSize = swipeLayoutHeight.value.minus(swipeLayoutComponentsHeight.value)
        Column(modifier = Modifier.onGloballyPositioned {
            swipeLayoutHeight = it.size.height.dp
        }) {
            CredLogoCircle(modifier = swipeModifier, shouldHide = viewModel.loading.value)
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 10.dp)
                    .onGloballyPositioned { it ->
                        swipeLayoutComponentsHeight = it.size.height.dp
                    },
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SwipeDownIcon(shouldHide = viewModel.loading.value)
                CircularHolder(viewModel.loading.value)

            }
        }
    }
}

