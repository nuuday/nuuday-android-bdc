package nuuday.android.sample.fragment

import nuuday.android.bdc.fragments.BehaviorDrivenFragment
import nuuday.android.bdc.fragments.standard_behaviors.CreateDatabindingViewBehavior
import nuuday.android.bdc.fragments.behavior.addAll
import nuuday.android.sample.R
import nuuday.android.sample.databinding.MainFragmentBinding

class MainFragment : BehaviorDrivenFragment() {

    init {
        behaviours.addAll(
            CreateDatabindingViewBehavior<MainFragmentBinding>(
                fragment = this,
                contentLayoutId = R.layout.main_fragment
            )
        )
    }

}
