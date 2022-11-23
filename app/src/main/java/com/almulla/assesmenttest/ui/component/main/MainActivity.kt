package com.almulla.assesmenttest.ui.component.main

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivityMainBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_toolbar.*


/** This activity is created for main  */
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainVm>(), View.OnClickListener {
    var mDrawerToggle: ActionBarDrawerToggle? = null

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun createViewModel(): Class<out MainVm> {
        return MainVm::class.java
    }

    override fun initViewBinding() {
        getBinding().apply {
            setToolBar()
            mDrawerToggle = ActionBarDrawerToggle(
                this@MainActivity,
                drawerLayout, mToolbar,
                R.string.app_name,
                R.string.app_name
            )


            supportActionBar!!.setHomeButtonEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

            drawerLayout.setDrawerListener(mDrawerToggle)


            mBottomNavigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {

                    R.id.nav_encryption -> {
                        findNavController(R.id.home_host_fragment).navigate(R.id.encryptionFragment)
                        return@setOnNavigationItemSelectedListener true
                    }

                    R.id.nav_to_do_list -> {
                        findNavController(R.id.home_host_fragment).navigate(R.id.toDoListFragment)
                        return@setOnNavigationItemSelectedListener true
                    }

                    R.id.nav_stopwatch -> {
                        findNavController(R.id.home_host_fragment).navigate(R.id.stopwatchFragment)
                        return@setOnNavigationItemSelectedListener true
                    }


                    else -> {
                        return@setOnNavigationItemSelectedListener false
                    }

                }
            }

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {

                    R.id.nav_change_language -> {
                        drawerLayout.closeDrawers()
                        return@setNavigationItemSelectedListener true
                    }

                    R.id.nav_logout -> {
                        drawerLayout.closeDrawers()
                        return@setNavigationItemSelectedListener true
                    }

                    else -> {
                        return@setNavigationItemSelectedListener false
                    }

                }
            }
        }

    }

    /**
     * setting the toolbar
     */
    private fun setToolBar() {
        setSupportActionBar(mToolbar)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle?.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mDrawerToggle?.onConfigurationChanged(newConfig)
    }


    override fun setVM(binding: ActivityMainBinding) {
    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {

    }
}