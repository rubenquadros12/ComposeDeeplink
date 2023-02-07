package com.example.composedeeplink

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

/**
 * Created by Ruben Quadros on 07/02/23
 **/
@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun AppScreens() {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController(bottomSheetNavigator)

    NavHost(navController = navController, startDestination = "Home") {

        composable(route = "Home") {
            ModalBottomSheetLayout(
                bottomSheetNavigator = bottomSheetNavigator,
                scrimColor = Color.Transparent,
                sheetBackgroundColor = Color.Black
            ) {
                HomeScreen(
                    normalScreen = { navController.navigate(route = "Second") },
                    deeplinkScreen = { navController.navigate(deepLink = Uri.parse("https://ruben.com/screen2")) },
                    normalSheet1 = { navController.navigate(route = "Sheet1") },
                    deeplinkSheet1 = { navController.navigate(deepLink = Uri.parse("https://ruben.com/sheet1")) },
                    normalSheet2 = { navController.navigate(route = "Sheet2") },
                    deeplinkSheet2 = { navController.navigate(deepLink = Uri.parse("https://ruben.com/sheet2")) }
                )
            }
        }

        composable(
            route = "Second",
            deepLinks = listOf(navDeepLink { uriPattern = "https://ruben.com/screen2" })
        ) {
            SecondScreen()
        }
        
        bottomSheet(
            route = "Sheet1",
            deepLinks = listOf(navDeepLink { uriPattern = "https://ruben.com/sheet1" })
        ) {
            BottomSheet1()
        }
        
        bottomSheet(
            route = "Sheet2",
            deepLinks = listOf(navDeepLink { uriPattern = "https://ruben.com/sheet2" })
        ) {
            BottomSheet2()
        }
    }
}