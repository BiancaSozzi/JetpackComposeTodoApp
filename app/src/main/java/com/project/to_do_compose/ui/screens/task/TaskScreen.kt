package com.project.to_do_compose.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.project.to_do_compose.data.models.Priority
import com.project.to_do_compose.data.models.ToDoTask
import com.project.to_do_compose.ui.screens.appBar.taskScreen.TaskAppBar
import com.project.to_do_compose.ui.viewmodels.SharedViewModel
import com.project.to_do_compose.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit,
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel
) {

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
                 TaskAppBar(navigateToListScreen = navigateToListScreen, selectedTask = selectedTask)
        },
        content = {
            TaskContent(
                title = title,
                onTitleChanged = { sharedViewModel.title.value = it },
                description = description,
                onDescriptionChanged = { sharedViewModel.description.value = it },
                priority = priority,
                onPrioritySelected = { sharedViewModel.priority.value = it }
            )
        }
    )
}