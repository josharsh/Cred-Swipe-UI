package com.cred.josharsh.credAnim.views.components.compounds

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.cred.josharsh.credAnim.R

@Composable
fun CredLogoCircle(modifier: Modifier, shouldHide: Boolean) {
    Card(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .width(IntrinsicSize.Min)
            .padding(5.dp)
            .clip(CircleShape)
            .background(Color.Black, CircleShape)
            .zIndex(10f),
        backgroundColor = Color.Black,
    ) {
        var painter = painterResource(id = R.drawable.cred_logo_white)
        if (!shouldHide) Image(
            modifier = Modifier
                .height(110.dp)
                .width(110.dp)
                .aspectRatio(
                    painter.intrinsicSize.height /
                            painter.intrinsicSize.width
                )
                .padding(15.dp, 10.dp),
            contentScale = ContentScale.Inside,
            painter = painter,
            contentDescription = stringResource(
                R.string.cred_logo_cd
            )
        )
    }
}

