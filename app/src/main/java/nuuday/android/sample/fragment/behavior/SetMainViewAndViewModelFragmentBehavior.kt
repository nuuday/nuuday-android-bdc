package nuuday.android.sample.fragment.behavior

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import nuuday.android.bdc.fragments.standard_behaviors.DatabindViewAndModelFragmentBehavior
import nuuday.android.sample.R
import nuuday.android.sample.fragment.MainViewModel

class SetMainViewAndViewModelFragmentBehavior<MainFragmentBinding>(
    private val fragment: Fragment
) : DatabindViewAndModelFragmentBehavior<nuuday.android.sample.databinding.MainFragmentBinding>(
    fragment,
    R.layout.main_fragment
) {

    override fun applyToBindings(binding: nuuday.android.sample.databinding.MainFragmentBinding) {
        binding.viewModel = ViewModelProviders.of(fragment).get(MainViewModel::class.java)
    }

}
