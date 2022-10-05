package com.project.to_do_compose.navigation

import androidx.navigation.NavHostController
import com.project.to_do_compose.util.Action
import com.project.to_do_compose.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/{$action.name}") {
            // Pop all the other actions from the stack
             popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/{$taskId}")
    }
}