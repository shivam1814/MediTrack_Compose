package com.shivam.meditrack.presentation.navigation

sealed class NavRoute(val route:String) {

    data object SplashScreen : NavRoute("splashScreen")

}