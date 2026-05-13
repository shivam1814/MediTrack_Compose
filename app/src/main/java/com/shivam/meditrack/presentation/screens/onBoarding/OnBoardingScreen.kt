package com.shivam.meditrack.presentation.screens.onBoarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shivam.meditrack.presentation.screens.components.TopAppBar
import com.shivam.meditrack.presentation.screens.onBoarding.components.OnBoardingContent1
import com.shivam.meditrack.presentation.screens.onBoarding.components.OnBoardingContent2
import com.shivam.meditrack.ui.theme.Pink40
import com.shivam.meditrack.ui.theme.Spacing
import com.shivam.meditrack.ui.theme.pagerUnSelectedDot
import com.shivam.meditrack.ui.theme.splashProgress
import com.shivam.meditrack.ui.theme.tertiary
import com.shivam.meditrack.ui.theme.white
import kotlinx.coroutines.launch

@Composable
@Preview(showSystemUi = true)
fun PreviewOnBoardingScreen() {

    OnBoardingScreen()

}

@Composable
fun OnBoardingScreen() {

    val infiniteTransition = rememberInfiniteTransition(label = "")

    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 15000,
                easing = LinearEasing
            )
        ),
        label = ""
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 3 }
    )

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {


            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                showBackIcon = false,
                showProfileIcon = false,
                showNotificationIcon = false
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->

                when (page) {
                    0 -> OnBoardingContent1(angle)
                    1 -> OnBoardingContent2()
                    2 -> Screen3()
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = Spacing.s20, end = Spacing.s20, bottom = Spacing.s10),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(3) { index ->

                        val isSelected = pagerState.currentPage == index

                        val width by animateDpAsState(
                            targetValue = if (isSelected) 32.dp else 8.dp,
                            animationSpec = tween(
                                durationMillis = 200
                            ),
                            label = ""
                        )

                        val color by animateColorAsState(
                            targetValue = if (isSelected) splashProgress else pagerUnSelectedDot,
                            animationSpec = tween(
                                durationMillis = 300
                            ),
                            label = ""
                        )

                        Box(
                            modifier = Modifier
                                .width(width)
                                .height(8.dp)
                                .clip(CircleShape)
                                .background(color)
                        )

                    }

                }


                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF006565),
                                    Color(0xFF008080)
                                ),
                                start = Offset.Zero,
                                end = Offset.Infinite
                            )
                        )
                        .clickable {
                            coroutineScope.launch {
                                if (pagerState.currentPage < 2) {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                } else {

                                }
                            }
                        }
                        .width(140.dp)
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (pagerState.currentPage == 2) {
                            "Start"
                        } else {
                            "Next"
                        },
                        color = white
                    )
                }

            }

        }
    }


}


@Composable
fun Screen2() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(tertiary),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen 2")
    }
}

@Composable
fun Screen3() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Pink40),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen 3")
    }
}