package nuuday.android.sample.activity

import android.os.Bundle
import music.core.composition.activities.BehaviorDrivenAppCompatActivity
import music.core.composition.activities.behaviors.SetDatabindingContentViewBehavior
import nuuday.android.sample.R
import nuuday.android.sample.activity.behavior.SimpleSplashMainActivityBehavior
import nuuday.android.sample.databinding.MainActivityBinding
import nuuday.android.sample.main.MainFragment

class MainActivity : BehaviorDrivenAppCompatActivity() {

    init{
        addBehaviors(
            SetDatabindingContentViewBehavior<MainActivityBinding>(this,R.layout.main_activity),
            SimpleSplashMainActivityBehavior(this)
        )
    }
}
