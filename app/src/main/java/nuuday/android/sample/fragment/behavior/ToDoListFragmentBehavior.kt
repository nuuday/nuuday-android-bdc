package nuuday.android.sample.fragment.behavior

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nuuday.android.bdc.fragments.behavior.FragmentBehaviour
import nuuday.android.sample.databinding.MainFragmentBinding
import nuuday.android.sample.fragment.MainViewModel
import nuuday.android.sample.fragment.adapter.ToDoAdapter


class ToDoListFragmentBehavior(
    private val fragment: Fragment
) : FragmentBehaviour {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainBinding = DataBindingUtil.getBinding<MainFragmentBinding>(view)
            ?: throw NullPointerException("Not correct binding")

        val viewModel = ViewModelProviders.of(fragment).get(MainViewModel::class.java)

        mainBinding.todoList.layoutManager = LinearLayoutManager(fragment.context, LinearLayoutManager.VERTICAL, false)
        mainBinding.todoList.adapter = ToDoAdapter(completeTodo = { index ->
            viewModel.removeTodo(index)
        })

        viewModel.todos.observe(fragment, { list ->
            val adapter = mainBinding.todoList.adapter as ToDoAdapter
            adapter.setData(list)
        })
    }


}
