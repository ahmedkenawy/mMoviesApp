package com.ahmedkenawy.moviesapp.features.main

import android.os.Bundle
import android.view.WindowManager
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ahmedkenawy.moviesapp.core.base.BaseActivity
import com.ahmedkenawy.moviesapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main entry point of the application.
 * This activity serves as the launcher activity and sets up the main user interface.
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<Any>() {
    /**
     * Tag used for logging and debugging purposes.
     */
    override val mTag = "MainActivity"
    /**
     * View binding instance for accessing views in the layout.
     */
    override val mBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        setUpViews()
    }

    override fun setUpViews() {
        installSplashScreen()
        // prevent user from taking a screen shot or record the screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
    }


}