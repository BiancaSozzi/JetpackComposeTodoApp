package com.project.to_do_compose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.project.to_do_compose.data.models.Priority
import com.project.to_do_compose.data.models.ToDoTask
import com.project.to_do_compose.ui.screens.appBar.taskScreen.TaskAppBar
import com.project.to_do_compose.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit,
    selectedTask: ToDoTask?
) {
    Scaffold(
        topBar = {
                 TaskAppBar(navigateToListScreen = navigateToListScreen, selectedTask = selectedTask)
        },
        content = {
            TaskContent(
                title = "",
                onTitleChanged = {},
                description = "",
                onDescriptionChanged = {},
                priority = Priority.LOW,
                onPrioritySelected = {}
            )
        }
    )
}