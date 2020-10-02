package music.core.composition.application

import android.app.Application
import nuuday.android.sample.applications.IBehaviorDrivenApplication
import nuuday.android.sample.applications.behavior.ApplicationBehavior

open class BehaviorDrivenApplication : Application(), IBehaviorDrivenApplication {

    override val behaviours = arrayListOf<ApplicationBehavior>()

    override fun onCreate() {
        super.onCreate()
        sendOnCreate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        sendOnLowMemory()
    }

}
