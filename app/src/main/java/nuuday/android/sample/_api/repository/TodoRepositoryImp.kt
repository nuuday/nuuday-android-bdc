package nuuday.android.sample._api.repository

import nuuday.android.sample._api.model.ToDo

/**
 * TODO: Use clients for managing memory, local and api storage
 */
class TodoRepositoryImp : ToDoRepository {

    val todoList: MutableList<ToDo> = ArrayList()

    var idCounter = 0

    override fun addTodo(text: String) {
        todoList.add(
            ToDo(
                uid = idCounter,
                index = todoList.size,
                text = text
            )
        )
        idCounter += 1
    }

    override fun deleteTodo(index: Int) {
        todoList.removeAt(index)
        val newList = todoList.mapIndexed { index, toDo ->  toDo.copy(index = index) }
        todoList.clear()
        todoList.addAll(newList)
    }

    override fun getTodos(): List<ToDo> = todoList.toList()

}
