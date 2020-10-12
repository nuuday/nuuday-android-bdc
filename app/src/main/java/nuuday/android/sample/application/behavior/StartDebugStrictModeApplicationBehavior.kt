package nuuday.android.sample.application.behavior

import android.os.StrictMode
import androidx.databinding.library.BuildConfig
import nuuday.android.bcc.applications.behavior.ApplicationBehavior

class StartDebugStrictModeApplicationBehavior : ApplicationBehavior {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {

            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyFlashScreen()
                    .penaltyLog()
                    .build()
            )

            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
        }
    }
}
