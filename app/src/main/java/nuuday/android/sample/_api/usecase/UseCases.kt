package nuuday.android.sample._api.usecase

interface UseCase{
    fun execute()
}

interface UseCaseOut<T>{
    fun execute(): T
}

interface UseCaseIn<T>{
    fun execute(input: T)
}

interface UseCaseIO<T, P>{
    fun execute(input: T): P
}
