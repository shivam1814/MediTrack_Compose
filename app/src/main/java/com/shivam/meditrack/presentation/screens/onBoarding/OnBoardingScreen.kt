package com.shivam.meditrack.presentation.screens.onBoarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shivam.meditrack.presentation.screens.components.TopAppBar
import com.shivam.meditrack.presentation.screens.onBoarding.components.OnBoardingContent1
import com.shivam.meditrack.ui.theme.Pink40
import com.shivam.meditrack.ui.theme.Purple40
import com.shivam.meditrack.ui.theme.PurpleGrey40
import com.shivam.meditrack.ui.theme.Spacing
import com.shivam.meditrack.ui.theme.secondary
import com.shivam.meditrack.ui.theme.tertiary
import com.shivam.meditrack.ui.theme.white
import kotlinx.coroutines.launch

@Composable
@Preview(showSystemUi = true)
fun Preview() {

    OnBoardingScreen()

}

@Composable
fun OnBoardingScreen() {

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
                    0 -> OnBoardingContent1()
                    1 -> Screen2()
                    2 -> Screen3()
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Spacing.s20),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                TextButton(
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(2)
                        }
                    }
                ) {
                    Text(text = "Skip")
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(3) { index ->

                        val isSelected = pagerState.currentPage == index

                        val width by animateDpAsState(
                            targetValue = if (isSelected) 24.dp else 8.dp,
                            animationSpec = tween(
                                durationMillis = 300
                            ),
                            label = ""
                        )

                        val color by animateColorAsState(
                            targetValue = if (isSelected) Purple40 else PurpleGrey40,
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

                Button(
                    onClick = {
                        coroutineScope.launch {
                            if (pagerState.currentPage < 2) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            } else {

                            }
                        }

                    }
                ) {
                    Text(
                        text = if (pagerState.currentPage == 2) {
                            "start"
                        } else {
                            "next"
                        }
                    )

                }

            }

        }
    }


}


@Composable
fun Screen1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(secondary),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Screen 1")
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