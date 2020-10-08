package nuuday.android.sample.applications

import nuuday.android.sample.applications.behavior.ApplicationBehavior

/**
 * If an application component is not supported then extend this interface
 *
 * Then use the send-methods to hook behaviors into the proper lifecycle
 */
interface IBehaviorDrivenApplication {

    val behaviours: MutableList<ApplicationBehavior>

    fun sendOnCreate() {
        behaviours.forEach { it.onCreate() }
    }

    fun sendOnLowMemory() {
        behaviours.forEach { it.onLowMemory() }
    }
}
