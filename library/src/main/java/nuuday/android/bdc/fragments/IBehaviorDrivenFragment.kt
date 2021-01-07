package nuuday.android.bdc.fragments

import android.os.Bundle
import android.view.*
import nuuday.android.bdc.fragments.behavior.FragmentBehaviour

interface IBehaviorDrivenFragment {

    val behaviours: MutableList<FragmentBehaviour>

    fun sendOnCreate(savedInstanceState: Bundle?) {
        behaviours.forEach {
            it.onCreate(savedInstanceState)
        }
    }

    fun tryView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        behaviours.forEach {
            val view = it.onCreateViewBehavior(inflater, container, savedInstanceState)
            if (view != null) {
                return view
            }
        }
        return null
    }

    fun sendOnViewStateRestored(savedInstanceState: Bundle?) {
        behaviours.forEach {
            it.onViewStateRestored(savedInstanceState)
        }
    }

    fun sendOnViewCreated(view: View, savedInstanceState: Bundle?) {
        behaviours.forEach {
            it.onViewCreated(view, savedInstanceState)
        }
    }

    fun sendOnResume() {
        behaviours.forEach {
            it.onResume()
        }
    }

    fun sendOnPause() {
        behaviours.forEach {
            it.onPause()
        }
    }

    fun sendOnDestroyAndTerminateBehaviors() {
        behaviours.forEach {
            it.onDestroy()
        }
    }

    fun sendOnStart() {
        behaviours.forEach {
            it.onStart()
        }
    }

    fun sendOnStop() {
        behaviours.forEach {
            it.onStop()
        }
    }

    fun sendOnCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
         behaviours.forEach {
             it.onCreateOptionsMenu(menu, inflater)
         }
     }
}
