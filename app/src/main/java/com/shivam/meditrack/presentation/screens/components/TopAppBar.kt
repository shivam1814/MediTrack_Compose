package com.shivam.meditrack.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.shivam.meditrack.R
import com.shivam.meditrack.ui.theme.Spacing
import com.shivam.meditrack.ui.theme.primary

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun Preview() {
    TopAppBar(
        showBackIcon = true,
        showProfileIcon = true,
        showNotificationIcon = true,
        modifier = Modifier.fillMaxWidth(),
        onBackClick = {},

    )
}


@Composable
fun TopAppBar(
    modifier: Modifier,
    showBackIcon: Boolean,
    showProfileIcon: Boolean,
    showNotificationIcon: Boolean,
    onBackClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(Spacing.s20)
    ) {
        if (showBackIcon) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = null,
                tint = primary
            )
        }

        if (showProfileIcon) {
            Image(
                painter = painterResource(R.drawable.ic_capsule_logo),
                contentDescription = null,
                modifier = Modifier.size(Spacing.s20)
            )
        }

    }
}