package nuuday.android.sample._api

interface ToDoRepository {

    fun addTodo(text: String)
    fun deleteTodo(index: Int)

}

