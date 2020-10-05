package music.core.composition.activities

import android.os.Bundle
import nuuday.android.sample.activities.behavior.ActivityBehaviour

/**
 * Any Activity that chooses to be a behavior driven Activity should refrain from using the internal lifecycle methods
 *
 * Instead, extract all behavior into ActivityBehaviors and add them in the init of the activity
 */
interface IBehaviorDrivenActivity {

    val behaviours: MutableList<ActivityBehaviour>

    fun sendOnCreate(savedInstanceState: Bundle?) {
        behaviours.forEach {
            it.onCreate(savedInstanceState)
        }
    }

    fun sendOnRestore(savedInstanceState: Bundle) {
        behaviours.forEach {
            it.onRestore(savedInstanceState)
        }
    }

    fun sendOnResume() {
        behaviours.forEach {
            it.onResume()
        }
    }

    fun sendOnPause() {
        behaviours.forEach {
            it.onPause()
        }
    }

    fun sendOnDestroy() {
        behaviours.forEach {
            it.onDestroy()
        }
    }

    fun sendOnStart() {
        behaviours.forEach {
            it.onStart()
        }
    }

    fun sendOnStop() {
        behaviours.forEach {
            it.onStop()
        }
    }

    /**
     * returns false if the back should be consumed by behaviors
     * and not propegate after
     */
    fun sendOnBack(): Boolean {
        var doSuperMethodAfterwards = true

        behaviours.forEach {
            val consume = it.onBack()
            if (consume) {
                doSuperMethodAfterwards = false
            }
        }

        return doSuperMethodAfterwards
    }

}
