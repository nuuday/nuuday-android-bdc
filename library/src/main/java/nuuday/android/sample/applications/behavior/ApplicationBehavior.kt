package nuuday.android.sample.applications.behavior

interface ApplicationBehavior {

    fun onCreate() {
        // Override in local behavior
    }

    fun onLowMemory() {
        // Override in local behavior
    }
}

fun MutableList<ApplicationBehavior>.addAll(vararg applicationBehaviors: ApplicationBehavior){
    addAll(applicationBehaviors)
}