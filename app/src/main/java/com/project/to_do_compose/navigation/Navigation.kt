package com.project.to_do_compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.project.to_do_compose.navigation.destinations.listComposable
import com.project.to_do_compose.navigation.destinations.taskComposable
import com.project.to_do_compose.util.Constants.LIST_SCREEN

@Composable
fun SetUpNavigation(
    navController: NavHostController
){
    // save our backstack of our composable screens through the application
    val screen = remember(navController) { Screens(navController) }

    // Definition of the navigation graph inside the nav host
    NavHost(navController, startDestination = LIST_SCREEN) {
        listComposable(
            // screen.task will navigate to the corresponding taskId screen
            navigateToTaskScreen = screen.task
        )
        taskComposable (
            navigateToListScreen = screen.list
        )
    }
}