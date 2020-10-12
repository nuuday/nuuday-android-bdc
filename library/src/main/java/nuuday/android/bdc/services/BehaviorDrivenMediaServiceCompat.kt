package nuuday.android.bdc.services


import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.support.v4.media.MediaBrowserCompat
import androidx.media.MediaBrowserServiceCompat
import music.core.composition.activities.IBehaviorDrivenService
import nuuday.android.bdc.services.behavior.ServiceBehavior

class BehaviorDrivenMediaServiceCompat : MediaBrowserServiceCompat(), IBehaviorDrivenService {

    override val behaviours: ArrayList<ServiceBehavior> = ArrayList()

    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot? {
        return sendOnGetRoot()
    }

    override fun onLoadChildren(
        parentId: String,
        result: Result<MutableList<MediaBrowserCompat.MediaItem>>
    ) {
        sendOnLoadChildren(parentId, result)
    }


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
