package com.shivam.meditrack.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.shivam.meditrack.R
import com.shivam.meditrack.ui.theme.Spacing
import com.shivam.meditrack.ui.theme.backIconColor
import com.shivam.meditrack.ui.theme.primary

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun Preview() {
    TopAppBar()
}


@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    showBackIcon: Boolean = true,
    showProfileIcon: Boolean = true,
    showNotificationIcon: Boolean = true,
    onBackClick: (() -> Unit)? = null,
    onProfileClick: (() -> Unit)? = null,
    onNotificationClick: (() -> Unit)? = null
) {

    val profileImageUrl by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(Spacing.s20),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (showBackIcon) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = null,
                    tint = backIconColor,
                    modifier = Modifier
                        .bounceClickable(onClick = onBackClick)
                        .size(Spacing.s28)
                )
                Spacer(
                    modifier = Modifier
                        .width(Spacing.s16)
                )
            }

            Text(
                text = "MediTrack",
                style = MaterialTheme.typography.titleLarge,
                color = primary
            )

        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (showNotificationIcon) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = backIconColor,
                    modifier = Modifier
                        .bounceClickable(onClick = onNotificationClick)
                        .size(Spacing.s28)
                )
            }


            if (showProfileIcon) {
                Spacer(
                    modifier = Modifier
                        .width(Spacing.s16)
                )


                if (profileImageUrl) {
                    AsyncImage(
                        model = profileImageUrl,
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(Spacing.s28)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = backIconColor,
                        modifier = Modifier
                            .bounceClickable(onClick = onProfileClick)
                            .size(Spacing.s28)

                    )
                }


            }


        }


    }
}