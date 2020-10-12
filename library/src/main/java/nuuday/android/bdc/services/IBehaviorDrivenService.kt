package music.core.composition.activities

import android.content.Intent
import android.os.IBinder
import android.support.v4.media.MediaBrowserCompat
import androidx.media.MediaBrowserServiceCompat
import nuuday.android.bdc.services.behavior.ServiceBehavior

/**
 * Any Activity that chooses to be a behavior driven Activity should refrain from using the internal lifecycle methods
 *
 * Instead, extract all behavior into ActivityBehaviors and add them in the init of the activity
 */
interface IBehaviorDrivenService {

    val behaviours: MutableList<ServiceBehavior>

    fun sendOnCreate() {
        behaviours.forEach {
            it.onCreate()
        }
    }

    fun sendOnDestroy() {
        behaviours.forEach {
            it.onDestroy()
        }
    }

    fun sendOnBind(intent: Intent?): IBinder? {
        behaviours.forEach {
            val binder = it.onBind(intent)
            if(binder != null)
                return binder
        }
        return null
    }

    fun sendOnGetRoot(): MediaBrowserServiceCompat.BrowserRoot? {
        behaviours.forEach {
            val root = it.getRoot()
            if(root != null)
                return root
        }
        return null
    }

    fun sendOnLoadChildren(
        parentId: String,
        result: MediaBrowserServiceCompat.Result<MutableList<MediaBrowserCompat.MediaItem>>
    ){
        behaviours.forEach {
            it.onLoadChildren(parentId, result)
        }
    }

     fun sendOnStartCommand(intent: Intent?, flags: Int, startId: Int): Int?{
         behaviours.forEach {
             val root = it.onStartCommand(intent, flags, startId)
             if(root != null)
                 return root
         }
         return null
     }

    fun sendOnRebind(intent: Intent?){
        behaviours.forEach {
            it.onRebind(intent)
        }
    }

}
