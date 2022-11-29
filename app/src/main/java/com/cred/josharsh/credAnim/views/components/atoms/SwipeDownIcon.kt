package com.cred.josharsh.credAnim.views.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cred.josharsh.credAnim.R

@Composable
fun SwipeDownIcon(shouldHide: Boolean) {
    val painter = painterResource(id = R.drawable.down_arrow_green)
    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
    ) {
        if (!shouldHide) Image(
            modifier = Modifier
                .width(25.dp)
                .padding(0.dp)
                .padding(top = 5.dp)
                .aspectRatio(
                    painter.intrinsicSize.height /
                            painter.intrinsicSize.width
                ),
            painter = painter,
            contentDescription = stringResource(R.string.swipe_down_icon_cd)
        )
    }
}