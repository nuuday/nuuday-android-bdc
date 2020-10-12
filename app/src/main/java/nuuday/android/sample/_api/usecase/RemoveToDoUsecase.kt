package nuuday.android.sample._api.usecase

import nuuday.android.sample._api.ToDoRepository

class RemoveToDoUsecase(
    private val repository: ToDoRepository
) : UseCaseIn<Int> {

    /**
     * Input is the index
     */
    override fun execute(input: Int) {
        repository.deleteTodo(input)
    }
}
