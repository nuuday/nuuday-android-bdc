package music.core.composition.fragments.behaviors

import androidx.databinding.ViewDataBinding

interface IBindingExecutor<T : ViewDataBinding> {

    fun applyToBinding(binding: T)
}
