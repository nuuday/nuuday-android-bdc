package nuuday.android.bdc.fragments.behavior

import android.app.Dialog
import android.os.Bundle
import android.view.*

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

    fun onCreateViewBehavior(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return null
    }

    fun onViewCreated(view: View, savedInstanceState: Bundle?){
        // Override for onViewCreated behavior
    }

    fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Override for onCreateOptionsMenu behavior
    }

    fun onDialogCreated(dialog: Dialog, savedInstanceState: Bundle?){
        // Override for onCreateDialog behavior ONLY in DialogFragments (otherwise it wont be called)
    }
}

fun MutableList<FragmentBehaviour>.addAll(vararg fragmentBehaviours: FragmentBehaviour){
    addAll(fragmentBehaviours)
}
