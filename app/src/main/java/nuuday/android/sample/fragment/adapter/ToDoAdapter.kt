package nuuday.android.sample.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import nuuday.android.sample.R
import nuuday.android.sample._api.model.ToDo
import nuuday.android.sample.databinding.ListitemTodoBinding

class ToDoAdapter(
    val completeTodo: (Int) -> Unit
) : RecyclerView.Adapter<ToDoAdapter.TodoViewHolder>() {

    private var todos: List<ToDo> = emptyList()

    init {
        setHasStableIds(true)
    }

    fun setData(todos: List<ToDo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListitemTodoBinding>(
            inflater,
            R.layout.listitem_todo,
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = todos[position]
        holder.binding.todoText.text = item.text
        holder.binding.doneWithTodoButton.setOnClickListener {
            completeTodo.invoke(item.index)
        }
    }

    override fun getItemCount(): Int {
        return this.todos.size
    }

    class TodoViewHolder(val binding: ListitemTodoBinding) :
        RecyclerView.ViewHolder(binding.root)

}
