package nuuday.android.bdc.fragments.standard_behaviors

import androidx.databinding.ViewDataBinding

interface IBindingExecutor<T : ViewDataBinding> {

    fun applyToBinding(binding: T)
}
