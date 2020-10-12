package music.core.composition.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import nuuday.android.bdc.fragments.behavior.FragmentBehaviour

open class BehaviorDrivenDialogFragment : DialogFragment(), IBehaviorDrivenFragment {

    override val behaviours: MutableList<FragmentBehaviour> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendOnCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return tryView(inflater, container, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        sendOnViewStateRestored(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendOnViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        sendOnResume()
    }

    override fun onPause() {
        super.onPause()
        sendOnPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        sendOnDestroyAndTerminateBehaviors()
    }

    override fun onStart() {
        super.onStart()
        sendOnStart()
    }

    override fun onStop() {
        super.onStop()
        sendOnStop()
    }
}
