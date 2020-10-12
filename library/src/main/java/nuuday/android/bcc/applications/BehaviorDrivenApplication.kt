package nuuday.android.bcc.applications

import android.app.Application
import nuuday.android.bcc.applications.IBehaviorDrivenApplication
import nuuday.android.bcc.applications.behavior.ApplicationBehavior

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
