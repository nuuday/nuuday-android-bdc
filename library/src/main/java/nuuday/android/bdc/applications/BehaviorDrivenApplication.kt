package nuuday.android.bdc.applications

import android.app.Application
import nuuday.android.bdc.applications.behavior.ApplicationBehavior

open class BehaviorDrivenApplication : Application(), IBehaviorDrivenApplication {

    override val behaviours: MutableList<ApplicationBehavior> = ArrayList()

    override fun onCreate() {
        super.onCreate()
        sendOnCreate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        sendOnLowMemory()
    }

}
