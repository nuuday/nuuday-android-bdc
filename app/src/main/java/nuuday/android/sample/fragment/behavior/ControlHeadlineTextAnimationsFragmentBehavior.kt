package nuuday.android.sample.fragment.behavior

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import nuuday.android.bdc.fragments.behavior.FragmentBehaviour
import nuuday.android.sample.R
import nuuday.android.sample.databinding.MainFragmentBinding
import nuuday.android.sample.fragment.MainViewModel


class ControlHeadlineTextAnimationsFragmentBehavior(
    private val fragment: Fragment
) : FragmentBehaviour {

    var initialHeightWelcomeHeadline: Int? = null
    var initialHeightDescriptionHeadline: Int? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainBinding = DataBindingUtil.getBinding<MainFragmentBinding>(view)
            ?: throw NullPointerException("Not correct binding")

        val viewModel = ViewModelProviders.of(fragment).get(MainViewModel::class.java)

        viewModel.todos.observe(fragment, { list ->

            // Only grab the values if we dont ahve them and the view is drawn (height > 0)
            if (initialHeightWelcomeHeadline == null
                && mainBinding.welcomeHeadline.height > 0
            ) {
                initialHeightWelcomeHeadline = mainBinding.welcomeHeadline.height
                initialHeightDescriptionHeadline =
                    mainBinding.welcomeDescription.height
            }

            if (list.size == 1) {
                mainBinding.todoText.hint = fragment.getString(R.string.hint_not_empty)
                collapse(mainBinding.welcomeHeadline, 1000, 0)
                collapse(mainBinding.welcomeDescription, 1000, 0)
            } else if (list.isEmpty()) {
                mainBinding.todoText.hint = fragment.getString(R.string.hint_empty)
                initialHeightWelcomeHeadline?.let {
                    expand(
                        mainBinding.welcomeHeadline,
                        1000,
                        it
                    )
                }
                initialHeightDescriptionHeadline?.let {
                    expand(
                        mainBinding.welcomeDescription,
                        1000,
                        it
                    )
                }
            }
        })
    }

    private fun expand(v: View, duration: Int, targetHeight: Int) {
        val prevHeight = v.height
        v.visibility = View.VISIBLE
        val valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight)
        valueAnimator.addUpdateListener { animation ->
            v.layoutParams.height = animation.animatedValue as Int
            v.requestLayout()
        }
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.duration = duration.toLong()
        valueAnimator.start()
    }

    private fun collapse(v: View, duration: Int, targetHeight: Int) {
        val prevHeight = v.height
        val valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight)
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.addUpdateListener { animation ->
            v.layoutParams.height = animation.animatedValue as Int
            v.requestLayout()
        }
        valueAnimator.interpolator = DecelerateInterpolator()
        valueAnimator.duration = duration.toLong()
        valueAnimator.start()
    }

}
