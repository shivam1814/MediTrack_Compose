package com.shivam.meditrack.presentation.screens.spalsh.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shivam.meditrack.ui.theme.primary
import com.shivam.meditrack.ui.theme.progressSplashBack
import com.shivam.meditrack.ui.theme.tertiary
import com.shivam.meditrack.ui.theme.white
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor

@Composable
@Preview(showBackground = true)
fun showPreview() {
    MediTrackSplashProgress(
        0.5f,
        Modifier
    )
}

@Composable
fun MediTrackSplashProgress(
    progress: Float,
    modifier: Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(14.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(progressSplashBack)

    ) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .clip(RoundedCornerShape(50.dp))
                .fillMaxWidth(progress.coerceIn(0f, 1f))
                .fillMaxHeight()
                .background(primary)
        )

    }


}