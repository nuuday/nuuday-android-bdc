package nuuday.android.sample.fragment.behavior

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import nuuday.android.bdc.fragments.behavior.FragmentBehaviour
import nuuday.android.sample.databinding.MainFragmentBinding

class NavigateToNuudayFragmentBehavior(
    private val fragment: Fragment
) : FragmentBehaviour {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainBinding = DataBindingUtil.getBinding<MainFragmentBinding>(view)
            ?: throw NullPointerException("Not correct binding")

        mainBinding.visitNuudayButton.setOnClickListener {
            // Strange English URL for Nuuday
            openWithChromeOrDefaultBrowser("https://nuuday.com/?_ga=2.154141688.1522986134.1602592361-2052711778.1601640763&_gac=1.12644293.1601640763.CjwKCAjwn9v7BRBqEiwAbq1Ey9n3yaRxy73jAPy5bQ1DTgcIDYxJjT1S-cZyIdgQL_I7qn3r5inSKxoCFxUQAvD_BwE")
        }

    }


    private fun openWithChromeOrDefaultBrowser(url: String) {
        try {
            fragment.startActivity(chromeIntent(url))
        } catch (ex: ActivityNotFoundException) {
            // Chrome browser presumably not installed so allow user to choose instead
            openWithDefaultBrowser(url)
        }
    }

    private fun openWithDefaultBrowser(url: String) {
        fragment.startActivity(defaultIntent(url))
    }

    private fun defaultIntent(url: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        return intent
    }

    private fun chromeIntent(url: String): Intent {
        val intent = defaultIntent(url)
        intent.setPackage("com.android.chrome")
        return intent
    }

}
