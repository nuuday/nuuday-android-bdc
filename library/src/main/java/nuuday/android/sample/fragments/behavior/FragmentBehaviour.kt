package nuuday.android.sample.fragments.behavior

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nuuday.android.sample.applications.behavior.ApplicationBehavior

interface FragmentBehaviour {

    fun onStart(){
        // Override for onStart behavior
    }

    fun onCreate(savedState: Bundle?){
        // Override for onCreate behavior
    }

    fun onViewStateRestored(savedState: Bundle?){
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

    fun onCreateViewBehavior(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return null
    }

    fun sendOnViewCreated(view: View, savedInstanceState: Bundle?){
        
    }
}

fun MutableList<FragmentBehaviour>.addAll(vararg fragmentBehaviours: FragmentBehaviour){
    addAll(fragmentBehaviours)
}
