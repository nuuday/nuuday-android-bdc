package nuuday.android.sample.fragment

import music.core.composition.fragments.BehaviorDrivenFragment
import music.core.composition.fragments.behaviors.CreateDatabindingViewBehavior
import nuuday.android.sample.R
import nuuday.android.sample.databinding.MainFragmentBinding
import nuuday.android.sample.fragments.behavior.addAll

class MainFragment : BehaviorDrivenFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    init {
        behaviours.addAll(
            CreateDatabindingViewBehavior<MainFragmentBinding>(
                fragment = this,
                contentLayoutId = R.layout.main_fragment
            )
        )
    }

}
