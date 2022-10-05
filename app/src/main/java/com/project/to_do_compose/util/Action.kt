package com.project.to_do_compose.util

// Represents the actions to be triggered to a DB table
enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}