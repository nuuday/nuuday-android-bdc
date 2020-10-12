package nuuday.android.sample.application.behavior

import nuuday.android.sample.BuildConfig
import nuuday.android.bdc.applications.behavior.ApplicationBehavior
import timber.log.Timber

class StartTimberApplicationBehavior: ApplicationBehavior {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


}
