package nuuday.android.sample.application

import nuuday.android.bdc.applications.BehaviorDrivenApplication
import nuuday.android.bdc.applications.behavior.addAll
import nuuday.android.sample.application.behavior.StartDebugStrictModeApplicationBehavior
import nuuday.android.sample.application.behavior.StartTimberApplicationBehavior

/**
 * Has your application class grown into a long and strange list of copy-pasted initializations
 * of strange sdks and libraries?
 *
 * Isolate your initializations into behaviors and use the power of composition
 */
class ToDoApplication : BehaviorDrivenApplication() {

    init {
        behaviours.addAll(
            StartTimberApplicationBehavior(),
            StartDebugStrictModeApplicationBehavior()
        )
    }

}
