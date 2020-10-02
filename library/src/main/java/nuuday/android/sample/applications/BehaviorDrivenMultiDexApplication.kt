package music.core.composition.application

import androidx.multidex.MultiDexApplication
import nuuday.android.sample.applications.IBehaviorDrivenApplication
import nuuday.android.sample.applications.behavior.ApplicationBehavior

open class BehaviorDrivenMultiDexApplication : MultiDexApplication(), IBehaviorDrivenApplication {

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
