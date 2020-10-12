package nuuday.android.bcc.services.behavior

import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.support.v4.media.MediaBrowserCompat
import androidx.media.MediaBrowserServiceCompat
import androidx.media.MediaBrowserServiceCompat.BrowserRoot

interface ServiceBehavior {

    fun onBind(intent: Intent?): IBinder? {
        return null
    }

    fun onRebind(intent: Intent?) {
        // Override for onRebind behavior
    }

    fun getRoot(): BrowserRoot? {
        // Override for onStart behavior
        return null
    }

    fun onCreate() {
        // Override for onCreate behavior
    }


    fun onStop() {
        // Override for onStop behavior
    }

    fun onDestroy() {
        // Override for onDestroy behavior
    }

    fun onLoadChildren(
        parentId: String,
        result: MediaBrowserServiceCompat.Result<MutableList<MediaBrowserCompat.MediaItem>>
    )

    fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int?{
        return null
    }
}

fun MutableList<ServiceBehavior>.addAll(vararg serviceBehaviors: ServiceBehavior) {
    addAll(serviceBehaviors)
}
