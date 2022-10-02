package com.project.to_do_compose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.to_do_compose.util.Constants.DATABASE_TABLE_NAME

@Entity(tableName = DATABASE_TABLE_NAME)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
