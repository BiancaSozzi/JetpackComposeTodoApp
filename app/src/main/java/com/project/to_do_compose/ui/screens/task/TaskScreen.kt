package com.project.to_do_compose.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
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

    val context = LocalContext.current

    Scaffold(
        topBar = {
                 TaskAppBar(
                     navigateToListScreen = { action ->
                         if (action == Action.NO_ACTION) {
                             // If close or back arrow were clicked
                             navigateToListScreen(action)
                         } else {
                             // If we are going to create or update the task
                             if (sharedViewModel.validateFields()) {
                                 navigateToListScreen(action)
                             } else {
                                 displayToast(context)
                             }
                         }
                     },
                     selectedTask = selectedTask)
        },
        content = {
            TaskContent(
                title = title,
                onTitleChanged = { sharedViewModel.updateTitle(it) },
                description = description,
                onDescriptionChanged = { sharedViewModel.description.value = it },
                priority = priority,
                onPrioritySelected = { sharedViewModel.priority.value = it }
            )
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty",
        Toast.LENGTH_LONG
    ).show()
}