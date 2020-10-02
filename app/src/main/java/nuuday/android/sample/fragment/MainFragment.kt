package nuuday.android.sample.fragment

import music.core.composition.fragments.BehaviorDrivenFragment
import music.core.composition.fragments.behaviors.CreateDatabindingViewBehavior
import nuuday.android.sample.R
import nuuday.android.sample.databinding.MainFragmentBinding

class MainFragment : BehaviorDrivenFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    init {
        addBehaviors(
            CreateDatabindingViewBehavior<MainFragmentBinding>(
                fragment = this,
                contentLayoutId = R.layout.main_fragment
            )
        )
    }

}
