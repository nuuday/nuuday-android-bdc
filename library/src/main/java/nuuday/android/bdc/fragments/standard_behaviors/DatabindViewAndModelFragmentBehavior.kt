package nuuday.android.bdc.fragments.standard_behaviors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import nuuday.android.bdc.fragments.behavior.FragmentBehaviour

abstract class DatabindViewAndModelFragmentBehavior<T : ViewDataBinding>(
    private val fragment: Fragment,
    private val contentLayoutId: Int,
    private val executePendingBindings: Boolean = false
) : FragmentBehaviour {

    lateinit var binding: T

    override fun onCreateViewBehavior(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<T>(
            inflater,
            contentLayoutId,
            container,
            false
        ).also {
            it.lifecycleOwner = fragment.viewLifecycleOwner
            applyToBindings(it)
        }

        if (executePendingBindings)
            binding.executePendingBindings()

        return binding.root
    }

    abstract fun applyToBindings(binding: T)
}
