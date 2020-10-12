package nuuday.android.sample.activity

import nuuday.android.bdc.activities.BehaviorDrivenAppCompatActivity
import nuuday.android.bdc.activities.behavior.addAll
import nuuday.android.bdc.activities.standard_behaviors.SetDatabindingContentViewBehavior
import nuuday.android.sample.R
import nuuday.android.sample.activity.behavior.SimpleSplashMainActivityBehavior
import nuuday.android.sample.databinding.MainActivityBinding

class MainActivity : BehaviorDrivenAppCompatActivity() {

    init {
        behaviours.addAll(
            SetDatabindingContentViewBehavior<MainActivityBinding>(this, R.layout.main_activity),
            SimpleSplashMainActivityBehavior(this)
        )
    }
}
