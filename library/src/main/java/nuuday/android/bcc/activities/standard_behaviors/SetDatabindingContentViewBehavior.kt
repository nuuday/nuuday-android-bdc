package music.core.composition.activities.behaviors

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import nuuday.android.bcc.activities.behavior.ActivityBehaviour

open class SetDatabindingContentViewBehavior<T : ViewDataBinding>(
    private val activity: Activity,
    private val contentLayoutId: Int
) : ActivityBehaviour {

    lateinit var binding: T

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        binding =
            DataBindingUtil.setContentView(activity, contentLayoutId)
    }
}
