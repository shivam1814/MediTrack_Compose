package com.shivam.meditrack.presentation.screens.spalsh.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shivam.meditrack.R
import com.shivam.meditrack.ui.theme.Spacing
import com.shivam.meditrack.ui.theme.primary
import com.shivam.meditrack.ui.theme.white

@Preview(showSystemUi = true)
@Composable
fun SplashScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(primary, white)
                )
            )
            .systemBarsPadding(),
    ) {

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                contentDescription = null,
                painter = painterResource(R.drawable.ic_capsule_light_back),
                modifier = Modifier
                    .size(Spacing.s250)
                    .align(Alignment.TopEnd)
                    .offset(x = Spacing.s75)
            )

            Image(
                contentDescription = null,
                painter = painterResource(R.drawable.ic_plus_light_back),
                modifier = Modifier
                    .padding(top = Spacing.s210)
                    .size(Spacing.s280)
                    .offset(x = -Spacing.s75)
            )


            Image(
                contentDescription = null,
                painter = painterResource(R.drawable.ic_capsule_logo),
                modifier = Modifier
                    .padding(top = Spacing.s80)
                    .size(Spacing.s210)
                    .align(Alignment.TopCenter)
            )


        }


    }
}