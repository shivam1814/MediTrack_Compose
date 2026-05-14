package com.shivam.meditrack.presentation.screens.onBoarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shivam.meditrack.R
import com.shivam.meditrack.ui.theme.Spacing
import com.shivam.meditrack.ui.theme.black
import com.shivam.meditrack.ui.theme.primary
import com.shivam.meditrack.ui.theme.tertiary
import com.shivam.meditrack.ui.theme.white

@Preview(showSystemUi = true)
@Composable
fun PreviewOnBoardingContent2() {
    OnBoardingContent2()
}


@Composable
fun OnBoardingContent2() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Spacing.s20)
    ) {

        Text(
            text = "Track Your Health",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.displayLarge,
            color = Color(0xFF191C1D),
            modifier = Modifier.fillMaxWidth(),

            )

        Text(
            text = "Track your medicine intake and view adherence progress with precision and calm",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF3E4949),
            modifier = Modifier.fillMaxWidth()
        )

        AdherenceContent()

    }


}

@Composable
fun AdherenceContent() {

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Spacing.s20),
        contentAlignment = Alignment.Center
    ) {

        val width = maxWidth

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 44.dp, horizontal = 20.dp)
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(32.dp),
                    ambientColor = Color.Black.copy(alpha = 0.2f),
                    spotColor = Color.Black.copy(alpha = 0.2f)
                )
                .background(white),
            contentAlignment = Alignment.Center
        ) {

            CircularProgressIndicator(
                progress = { 0.8f },
                modifier = Modifier.fillMaxSize().align(Alignment.Center)
            )

        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AdherenceItem(
                width,
                R.drawable.ic_correct, "STATUS",
                "All Taken",
                Color(0xFF83FC8E),
                modifier = Modifier.align(Alignment.End)
            )
            AdherenceItem(
                width,
                R.drawable.ic_history_gain,
                "HISTORY",
                "+12% Gain",
                Color(0xFF93F2F2),
                modifier = Modifier.align(alignment = Alignment.Start)
            )
        }


        /*Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Spacing.s50, vertical = Spacing.s)
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(48.dp),
                    ambientColor = Color.Black.copy(alpha = 0.2f),
                    spotColor = Color.Black.copy(alpha = 0.2f)
                )
                .background(white),
            contentAlignment = Alignment.Center
        ) {

        }*/


    }

}

@Composable
fun AdherenceItem(
    width: Dp,
    icon: Int,
    txt1: String,
    txt2: String,
    color: Color,
    modifier: Modifier
) {


    Box(
        modifier = modifier
            .width(width / 2)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(32.dp),
                ambientColor = color,
                spotColor = color
            )
            .background(white)

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing.s20)
        ) {

            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = txt1,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF3E4949),
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = txt2,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF006923),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                )

            }


        }


    }

}