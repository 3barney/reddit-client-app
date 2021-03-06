package events254.wakenyawawili.com.kedditbysteps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import events254.wakenyawawili.com.kedditbysteps.features.news.NewsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            changeFragment(NewsFragment())
        }
    }

    private fun changeFragment(f: Fragment, cleanStack: Boolean = false) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (cleanStack) {
            clearBackStack()
        }

        fragmentTransaction.setCustomAnimations(
            R.anim.abc_fade_in, R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit
        );
        fragmentTransaction.replace(R.id.activity_base_content, f)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun clearBackStack() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            val firstItem = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(firstItem.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val fragmentManager =  supportFragmentManager
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            finish()
        }

    }
}
