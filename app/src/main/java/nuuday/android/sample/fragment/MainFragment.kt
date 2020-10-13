package nuuday.android.sample.fragment

import nuuday.android.bdc.fragments.BehaviorDrivenFragment
import nuuday.android.bdc.fragments.behavior.addAll
import nuuday.android.sample.databinding.MainFragmentBinding
import nuuday.android.sample.fragment.behavior.*

class MainFragment : BehaviorDrivenFragment() {

    init {
        behaviours.addAll(
            SetMainViewAndViewModelFragmentBehavior<MainFragmentBinding>(fragment = this),
            ControlHeadlineTextAnimationsFragmentBehavior(this),
            ToDoListFragmentBehavior(this),
            NavigateToNuudayFragmentBehavior(this),
            ControlInputDoneActionFragmentBehavior(this)
        )
    }

}
