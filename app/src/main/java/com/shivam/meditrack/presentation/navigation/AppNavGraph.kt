package com.shivam.meditrack.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shivam.meditrack.presentation.screens.onBoarding.OnBoardingScreen
import com.shivam.meditrack.presentation.screens.spalsh.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = NavRoute.OnBoardingScreen.route
    ) {

        composable(NavRoute.SplashScreen.route) {
            SplashScreen()
        }

        composable(NavRoute.OnBoardingScreen.route){
            OnBoardingScreen()
        }

    }

}