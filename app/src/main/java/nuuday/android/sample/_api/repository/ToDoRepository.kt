package nuuday.android.sample._api.repository

import nuuday.android.sample._api.model.ToDo

interface ToDoRepository {

    fun addTodo(text: String)
    fun deleteTodo(index: Int)
    fun getTodos(): List<ToDo>

}

