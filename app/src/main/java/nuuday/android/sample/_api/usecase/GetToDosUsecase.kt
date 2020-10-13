package nuuday.android.sample._api.usecase

import nuuday.android.sample._api.model.ToDo
import nuuday.android.sample._api.repository.ToDoRepository

class GetToDosUsecase(
    private val repository: ToDoRepository
) : UseCaseOut<List<ToDo>> {
    override fun execute(): List<ToDo> =  repository.getTodos()
}
