package nuuday.android.sample.application

import music.core.composition.application.BehaviorDrivenApplication
import nuuday.android.sample.application.behavior.StartDebugStrictModeApplicationBehavior
import nuuday.android.sample.application.behavior.StartTimberApplicationBehavior

class ToDoApplication : BehaviorDrivenApplication() {

    init {
        addBehaviors(
            StartTimberApplicationBehavior(),
            StartDebugStrictModeApplicationBehavior()
        )
    }

}
