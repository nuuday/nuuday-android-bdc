package music.core.composition.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nuuday.android.bcc.activities.behavior.ActivityBehaviour

/**
 * Any Activity that chooses to be a behavior driven Activity should refrain from using the internal lifecycle methods
 *
 * Instead, extract all behavior into ActivityBehaviors and add them in the init of the activity
 */
open class BehaviorDrivenAppCompatActivity : AppCompatActivity(), IBehaviorDrivenActivity {

    override val behaviours: MutableList<ActivityBehaviour> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendOnCreate(savedInstanceState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        sendOnRestore(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        sendOnResume()
    }

    override fun onPause() {
        super.onPause()
        sendOnPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        sendOnDestroy()
    }

    override fun onStart() {
        super.onStart()
        sendOnStart()
    }

    override fun onStop() {
        super.onStop()
        sendOnStop()
    }

    override fun onBackPressed() {
        val doSuperMethodAfterwards = sendOnBack()
        if (doSuperMethodAfterwards)
            super.onBackPressed()
    }

}
