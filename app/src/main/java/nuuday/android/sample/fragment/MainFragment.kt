package nuuday.android.sample.fragment

import nuuday.android.bdc.fragments.BehaviorDrivenFragment
import nuuday.android.bdc.fragments.behavior.addAll
import nuuday.android.sample.databinding.MainFragmentBinding
import nuuday.android.sample.fragment.behavior.ControlWelcomeTextFragmentBehavior
import nuuday.android.sample.fragment.behavior.NavigateToNuudayFragmentBehavior
import nuuday.android.sample.fragment.behavior.SetMainViewAndViewModelFragmentBehavior
import nuuday.android.sample.fragment.behavior.ToDoListFragmentBehavior

class MainFragment : BehaviorDrivenFragment() {

    init {
        behaviours.addAll(
            SetMainViewAndViewModelFragmentBehavior<MainFragmentBinding>(fragment = this),
            ControlWelcomeTextFragmentBehavior(this),
            ToDoListFragmentBehavior(this),
            NavigateToNuudayFragmentBehavior(this)
        )
    }

}
