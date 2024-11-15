package com.example.boardingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.boardingapp.dataStore.StoreBoarding
import com.example.boardingapp.onBoardViews.MainOnBoarding
import com.example.boardingapp.views.HomeView
import com.example.boardingapp.views.SplashScreen

@Composable
fun NavManager(){
    val context = LocalContext.current
    val dataStore= StoreBoarding(context)
    val store  =dataStore.getStoreBoarding.collectAsState(initial = false)

    val navController =  rememberNavController()
    NavHost(navController=navController, startDestination = if(store.value==true) "home" else "Splash"){
        composable("onBoarding"){
            MainOnBoarding(navController,dataStore)
        }
        composable("home"){
            HomeView(navController)
        }
        composable("Splash"){
            SplashScreen(navController, store.value)
        }
    }
}