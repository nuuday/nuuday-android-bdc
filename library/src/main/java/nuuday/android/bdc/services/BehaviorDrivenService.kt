package nuuday.android.bdc.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import music.core.composition.activities.IBehaviorDrivenService
import nuuday.android.bdc.services.behavior.ServiceBehavior

open class BehaviorDrivenService : Service(), IBehaviorDrivenService {

    override val behaviours: ArrayList<ServiceBehavior> = ArrayList()

    override fun onCreate() {
        super.onCreate()
        sendOnCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        sendOnDestroy()
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        sendOnRebind(intent)
   }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return sendOnStartCommand(
            intent,
            flags,
            startId
        ) ?: super.onStartCommand(
            intent,
            flags,
            startId
        )
    }


    override fun onBind(intent: Intent?): IBinder? {
        return sendOnBind(intent)
    }


}
