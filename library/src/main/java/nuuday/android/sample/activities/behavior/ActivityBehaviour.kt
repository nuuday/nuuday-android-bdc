package nuuday.android.sample.activities.behavior

import android.os.Bundle

interface ActivityBehaviour {

    fun onStart(){
        // Override for onStart behavior
    }

    fun onCreate(savedState: Bundle?){
        // Override for onCreate behavior
    }

    fun onRestore(savedState: Bundle){
        // Override for onCreate behavior
    }

    fun onResume(){
        // Override for onResume behavior
    }

    fun onPause(){
        // Override for onPause behavior
    }

    fun onStop(){
        // Override for onStop behavior
    }

    fun onDestroy(){
        // Override for onDestroy behavior
    }

    fun onBack(): Boolean = false

}
