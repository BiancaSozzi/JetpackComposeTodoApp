package com.project.to_do_compose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.project.to_do_compose.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDAO {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun createTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchTask(searchQuery: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY " +
            "CASE " +
            "   WHEN priority = 'LOW' THEN 1 " +
            "   WHEN priority = 'MEDIUM' THEN 2" +
            "   WHEN priority = 'HIGH' THEN 3 " +
            "END")
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER BY " +
            "CASE " +
            "   WHEN priority = 'HIGH' THEN 1 " +
            "   WHEN priority = 'MEDIUM' THEN 2" +
            "   WHEN priority = 'LOW' THEN 3 " +
            "END")
    fun sortByHighPriority(): Flow<List<ToDoTask>>
}

/*
 Flow runs already as asynchronous, that's why we don't need to define the select funcs
 as suspend
 */