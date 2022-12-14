package com.project.to_do_compose.navigation.destinations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.project.to_do_compose.ui.screens.list.ListScreen
import com.project.to_do_compose.ui.viewmodels.SharedViewModel
import com.project.to_do_compose.util.Constants.LIST_ARGUMENT_KEY
import com.project.to_do_compose.util.Constants.LIST_SCREEN
import com.project.to_do_compose.util.toAction

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit, // knows how to navigate to the task screen
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        /* Launches a block into the composition coroutine context
        and the launch effect will be cancelled and relaunched when the launch effect recompose with a new key */
        LaunchedEffect(key1 = action) {
            sharedViewModel.action.value = action
        }

        ListScreen(navigateToTaskScreen = navigateToTaskScreen, sharedViewModel = sharedViewModel)
    }
}