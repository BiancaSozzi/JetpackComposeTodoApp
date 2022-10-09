package com.project.to_do_compose.ui.screens.appBar.listScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.project.to_do_compose.R
import com.project.to_do_compose.ui.theme.TOP_APP_BAR_HEIGHT
import com.project.to_do_compose.ui.theme.topAppBarBackgroundColor
import com.project.to_do_compose.ui.theme.topAppBarContentColor
import com.project.to_do_compose.ui.viewmodels.SharedViewModel
import com.project.to_do_compose.util.SearchAppBarState

@Composable
fun SearchAppBar(
    text: String,
    sharedViewModel: SharedViewModel
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackgroundColor
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = { newText -> sharedViewModel.searchTextState.value = newText },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_placeholder_text),
                    color = Color.White,
                    modifier = Modifier.alpha(ContentAlpha.medium)
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true, // text will not occupy multiple lines
            leadingIcon = {
                IconButton(
                    onClick = { onSearchClicked(text, sharedViewModel) },
                    modifier = Modifier.alpha(ContentAlpha.disabled)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(id = R.string.search_button),
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    val searchTextValue = sharedViewModel.searchTextState.value
                    if (searchTextValue.isNotEmpty()) {
                        sharedViewModel.searchTextState.value = ""
                    } else {
                        sharedViewModel.searchAppBarState.value = SearchAppBarState.CLOSED
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.close_search_button),
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                // It will include the search button on the keyboard
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                // When the user clicks on the search button of the keyboard, it should trigge the search
                onSearch = {
                    onSearchClicked(text, sharedViewModel)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topAppBarContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            )
        )
    }

}

private fun onSearchClicked(text: String, viewModel: SharedViewModel) {
    viewModel.searchAppBarState.value = SearchAppBarState.TRIGGERED
}