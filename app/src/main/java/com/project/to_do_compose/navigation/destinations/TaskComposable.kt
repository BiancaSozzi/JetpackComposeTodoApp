package com.project.to_do_compose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.project.to_do_compose.util.Action
import com.project.to_do_compose.util.Constants.TASK_ARGUMENT_KEY
import com.project.to_do_compose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        // Get the taskId from the route argument
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
    }
}