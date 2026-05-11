package com.shivam.meditrack.presentation.screens.spalsh

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.shivam.meditrack.R
import com.shivam.meditrack.presentation.screens.spalsh.component.MediTrackSplashProgress
import com.shivam.meditrack.ui.theme.InterFontFamily
import com.shivam.meditrack.ui.theme.MediTrackTheme
import com.shivam.meditrack.ui.theme.Spacing
import com.shivam.meditrack.ui.theme.primary
import com.shivam.meditrack.ui.theme.white

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {

    MediTrackTheme {
        SplashScreen()
    }

}

@Composable
fun SplashScreen(navController: NavController = rememberNavController()) {


    var progress by remember {
        mutableFloatStateOf(0f)
    }


    LaunchedEffect(Unit) {
        animate(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = tween(4000)
        ) { value, _ ->
            progress = value
        }
    }

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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Spacing.s20),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                contentDescription = null,
                painter = painterResource(R.drawable.ic_capsule_logo),
                modifier = Modifier
                    .size(Spacing.s210),
            )


            Text(
                text = "MediTrack",
                style = MaterialTheme.typography.displayLarge,
                color = Color(0xFF191C1D),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(Spacing.s10)
            )

            Text(
                text = "Never miss your medicine again",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF3E4949),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            MediTrackSplashProgress(
                progress = progress,
                modifier = Modifier
                    .padding(top = Spacing.s60)
                    .fillMaxWidth()
            )


        }


    }
}