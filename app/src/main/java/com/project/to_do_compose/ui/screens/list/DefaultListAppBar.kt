package com.project.to_do_compose.ui.screens.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.project.to_do_compose.data.models.Priority
import com.project.to_do_compose.ui.theme.topAppBarBackgroundColor
import com.project.to_do_compose.ui.theme.topAppBarContentColor

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ListAppBarActions(onSearchClicked, onSortClicked, onDeleteClicked)
        }
    )
}