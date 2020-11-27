package nuuday.android.sample.fragment.behavior

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import nuuday.android.bdc.fragments.behavior.FragmentBehaviour
import nuuday.android.sample.databinding.MainFragmentBinding
import nuuday.android.sample.fragment.MainViewModel


class ControlInputDoneActionFragmentBehavior(
    private val fragment: Fragment
) : FragmentBehaviour {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainBinding = DataBindingUtil.getBinding<MainFragmentBinding>(view)
            ?: throw NullPointerException("Not correct binding")

        val viewModel = ViewModelProviders.of(fragment).get(MainViewModel::class.java)

        mainBinding.todoText.setOnEditorActionListener { _, _, _ ->
            viewModel.addTodo()
            true
        }
    }

}
