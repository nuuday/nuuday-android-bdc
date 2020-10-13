package nuuday.android.sample.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nuuday.android.sample._api.model.ToDo
import nuuday.android.sample._api.repository.ToDoRepository
import nuuday.android.sample._api.repository.TodoRepositoryImp
import nuuday.android.sample._api.usecase.AddToDoUsecase
import nuuday.android.sample._api.usecase.GetToDosUsecase
import nuuday.android.sample._api.usecase.RemoveToDoUsecase

class MainViewModel : ViewModel() {

    //ToDo: Do not expose repository in viewmodel, only expose usecases, use dependency injection for this
    private val todoRepo: ToDoRepository = TodoRepositoryImp()

    private val addToDoUsecase = AddToDoUsecase(todoRepo)
    private val removeToDoUsecase = RemoveToDoUsecase(todoRepo)
    private val getToDosUsecase = GetToDosUsecase(todoRepo)

    val todos: MutableLiveData<List<ToDo>> = MutableLiveData()
    var input = MutableLiveData<String>()

    init {
        refreshTodos()
    }

    private fun refreshTodos() {
        todos.value = getToDosUsecase.execute()
    }


    fun addTodo() {
        val inputString = input.value

        if (inputString.isNullOrEmpty())
            return

        input.value = ""

        addToDoUsecase.execute(inputString.trim())
        refreshTodos()
    }

    fun removeTodo(index: Int) {
        removeToDoUsecase.execute(index)
        refreshTodos()
    }


}
