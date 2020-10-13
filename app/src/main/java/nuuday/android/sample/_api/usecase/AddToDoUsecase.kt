package nuuday.android.sample._api.usecase

import nuuday.android.sample._api.repository.ToDoRepository

class AddToDoUsecase(
    private val repository: ToDoRepository
) : UseCaseIn<String> {
    override fun execute(input: String) {
        repository.addTodo(input)
    }
}
