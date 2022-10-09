package com.project.to_do_compose.ui.screens.appBar.listScreen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.project.to_do_compose.R
import com.project.to_do_compose.data.models.Priority
import com.project.to_do_compose.ui.theme.topAppBarBackgroundColor
import com.project.to_do_compose.ui.theme.topAppBarContentColor

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteAllClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.list_screen_title),
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ListAppBarActions(onSearchClicked, onSortClicked, onDeleteAllClicked)
        }
    )
}