package nuuday.android.sample.activity.behavior

import android.animation.Animator
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import nuuday.android.sample.R
import nuuday.android.sample.activities.behavior.ActivityBehaviour

class SimpleSplashMainActivityBehavior(
    private val activity: Activity
) : ActivityBehaviour {

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        val splash = activity.findViewById<View>(R.id.splashLayout)

        splash.visibility = View.VISIBLE
        splash
            .animate()
            .alpha(0.0f)
            .setStartDelay(1500)
            .setDuration(500)
            .setListener(object:  Animator.AnimatorListener {

                override fun onAnimationStart(animation: Animator?) {
                   // Nothing
                }

                override fun onAnimationEnd(animation: Animator?) {
                    splash.visibility = View.GONE
                }

                override fun onAnimationCancel(animation: Animator?) {
                    // Nothing
                }

                override fun onAnimationRepeat(animation: Animator?) {
                    // Nothing
                }

            });
    }


}
