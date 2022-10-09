package com.project.to_do_compose.ui.screens.appBar.listScreen

import androidx.compose.runtime.Composable
import com.project.to_do_compose.ui.viewmodels.SharedViewModel
import com.project.to_do_compose.util.Action
import com.project.to_do_compose.util.SearchAppBarState

@Composable
fun ListAppBar(
    sharedViewModel: SharedViewModel,
    searchAppBarState: SearchAppBarState,
    searchTextState: String
) {
    when(searchAppBarState) {
        SearchAppBarState.CLOSED -> {
            DefaultListAppBar(
                onSearchClicked = {
                    sharedViewModel.searchAppBarState.value = SearchAppBarState.OPENED
                },
                onSortClicked = {

                },
                onDeleteAllClicked = {
                    sharedViewModel.action.value = Action.DELETE_ALL
                })
        } 
        else -> SearchAppBar(
            text = searchTextState,
            sharedViewModel = sharedViewModel
        )
    }
}

//@Composable
//@Preview
//private fun DefaultListAppBarPreview() {
//    DefaultListAppBar(onSearchClicked = {}, onSortClicked = {}, onDeleteClicked = {})
//}
//
//@Composable
//@Preview
//private fun SearchAppBarPreview() {
//    SearchAppBar(text = "Search", onTextChanged = {}, onCloseClicked = {}, onSearchClicked = {})
//}
