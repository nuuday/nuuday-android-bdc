package nuuday.android.sample.activity

import android.os.Bundle
import music.core.composition.activities.BehaviorDrivenAppCompatActivity
import nuuday.android.sample.R
import nuuday.android.sample.main.MainFragment

class MainActivity : BehaviorDrivenAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}
