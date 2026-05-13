package com.shivam.meditrack.presentation.screens.onBoarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shivam.meditrack.R
import com.shivam.meditrack.ui.theme.Spacing
import com.shivam.meditrack.ui.theme.primary
import com.shivam.meditrack.ui.theme.white
import kotlin.math.cos
import kotlin.math.sin

@Composable
@Preview(showSystemUi = true)
fun PreviewOnBoardingContent1() {
    OnBoardingContent1(angle = 10f)
}


@Composable
fun OnBoardingContent1(angle: Float) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Spacing.s20)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {


            MiddleAnimateContent(angle)

        }
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF191C1D)
                    )
                ) {
                    append(text = "Medicine ")
                }
                withStyle(
                    style = SpanStyle(
                        color = primary
                    )
                ) {
                    append(text = "Reminders")
                }
            },
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Set reminders for your daily\n" +
                    "medicines and never miss a dose\n" +
                    "We'll keep your schedule on track",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF3E4949),
            modifier = Modifier.fillMaxWidth()
        )
    }


}


@Composable
fun MiddleAnimateContent(angle: Float) {

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val circleSize = maxWidth * 0.6f
        val innerIconSize = circleSize * 0.4f
        val orbitRadius = circleSize / 2f
        val orbitItemSize = circleSize * 0.3f

        Box(
            modifier = Modifier
                .size(circleSize)
                .shadow(
                    elevation = 20.dp,
                    shape = CircleShape,
                    ambientColor = Color.Black.copy(alpha = 0.3f),
                    spotColor = Color.Black.copy(alpha = 0.3f)
                )
                .background(white),
            contentAlignment = Alignment.Center
        ) {

            Image(
                contentDescription = null,
                painter = painterResource(R.drawable.ic_main_notification),
                modifier = Modifier
                    .size(innerIconSize),
            )


        }

        OrbitItem(
            angle = angle,
            radius = orbitRadius,
            size = orbitItemSize,
            icon = R.drawable.ic_medicine_container,
            backgroundColor = Color(0xFF66DF75),
        )

        OrbitItem(
            angle = angle - 120f,
            radius = orbitRadius,
            size = orbitItemSize,
            icon = R.drawable.ic_orbititem_2,
            backgroundColor = Color(0xFFC5E9E9),
        )


    }


}


@Composable
fun OrbitItem(
    angle: Float,
    radius: Dp,
    size: Dp,
    icon: Int,
    backgroundColor: Color,
) {

    val angleInRad = Math.toRadians(angle.toDouble())

    val x = (cos(angleInRad) * radius.value).dp
    val y = (sin(angleInRad) * radius.value).dp

    Box(
        modifier = Modifier
            .offset(x = x, y = y)
            .size(size)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(size * 0.5f)
        )


    }

}

























