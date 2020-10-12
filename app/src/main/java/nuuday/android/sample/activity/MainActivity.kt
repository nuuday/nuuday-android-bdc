package nuuday.android.sample.activity

import music.core.composition.activities.BehaviorDrivenAppCompatActivity
import music.core.composition.activities.behaviors.SetDatabindingContentViewBehavior
import nuuday.android.bdc.activities.behavior.addAll
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
