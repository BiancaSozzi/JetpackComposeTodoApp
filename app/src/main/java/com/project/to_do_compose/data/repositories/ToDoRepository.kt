package com.project.to_do_compose.data.repositories

import com.project.to_do_compose.data.ToDoDAO
import com.project.to_do_compose.data.models.ToDoTask
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class ToDoRepository @Inject constructor(private val toDoDAO: ToDoDAO) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDAO.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = toDoDAO.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = toDoDAO.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> = toDoDAO.getSelectedTask(taskId)

    suspend fun addTask(toDoTask: ToDoTask) = toDoDAO.createTask(toDoTask)
    suspend fun updateTask(toDoTask: ToDoTask) = toDoDAO.updateTask(toDoTask)
    suspend fun deleteTask(toDoTask: ToDoTask) = toDoDAO.deleteTask(toDoTask)
    suspend fun deleteAllTasks() = toDoDAO.deleteAllTasks()

    fun searchTask(searchKey: String): Flow<List<ToDoTask>> = toDoDAO.searchTask(searchKey)

}