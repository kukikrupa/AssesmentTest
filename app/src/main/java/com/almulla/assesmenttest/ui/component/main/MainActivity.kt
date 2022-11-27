package com.almulla.assesmenttest.ui.component.main

import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.ActivityMainBinding
import com.almulla.assesmenttest.ui.base.BaseActivity
import com.almulla.assesmenttest.ui.component.change_language.ChangeLanguageActivity
import com.almulla.assesmenttest.ui.component.login.LoginActivity
import com.almulla.assesmenttest.ui.component.main.to_do.Task
import com.almulla.assesmenttest.utils.*
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

            text_welcome.text = "Welcome " + getUserName()

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
                        startActivity(Intent(this@MainActivity, ChangeLanguageActivity::class.java))
                        return@setNavigationItemSelectedListener true
                    }

                    R.id.nav_logout -> {
                        drawerLayout.closeDrawers()
                        showLogoutDialog()
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

    private fun showLogoutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Demo App")
        builder.setMessage(getString(R.string.are_you_sure_you_want_logout))

        builder.setPositiveButton(getString(R.string.cancel)) { dialog, which ->
            dialog.dismiss()
        }

        builder.setNegativeButton(getString(R.string.ok)) { dialog, which ->
            dialog.dismiss()
            logoutUser()
        }

        builder.show()
    }

    private fun logoutUser() {
        clearUserData()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == NAVIGATION_TO_TASK) {
            val name: String = data?.getStringExtra(TASK_NAME) ?: ""
            val date: String = data?.getStringExtra(TASK_DATE) ?: ""
            viewModel.addTask(Task(name, date))
        }
    }
}