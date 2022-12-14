package com.project.to_do_compose.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.project.to_do_compose.ui.screens.task.TaskScreen
import com.project.to_do_compose.ui.viewmodels.SharedViewModel
import com.project.to_do_compose.util.Action
import com.project.to_do_compose.util.Constants.TASK_ARGUMENT_KEY
import com.project.to_do_compose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit, // knows how to navigate to the list screen
    sharedViewModel: SharedViewModel
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        // Get the taskId from the route argument
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)

        LaunchedEffect(key1 = taskId) {
            sharedViewModel.getSelectedTask(taskId)
        }

        // observe value
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        // Key is selectedTask so that when the fields are filled they have the latest data
        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskFields(selectedTask)
            }
        }

        TaskScreen(navigateToListScreen = navigateToListScreen, selectedTask = selectedTask, sharedViewModel = sharedViewModel)
    }
}