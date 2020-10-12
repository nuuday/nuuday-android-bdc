package nuuday.android.sample._api

import nuuday.android.sample._api.model.ToDo

interface ToDoRepository {

    fun addTodo(text: String)
    fun deleteTodo(index: Int)
    fun getTodos(): List<ToDo>

}

