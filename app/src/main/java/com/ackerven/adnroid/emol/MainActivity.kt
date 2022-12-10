package com.ackerven.adnroid.emol

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolBar()
        hideStatusBar()
    }

    private fun setToolBar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitleTextColor(Color.BLACK)
        setSupportActionBar(toolbar)
    }

    private fun hideStatusBar() {
        //关键代码,沉浸
//        WindowCompat.setDecorFitsSystemWindows(window, false)

        //设置专栏栏和导航栏的底色，透明
        window.statusBarColor = Color.parseColor("#00000000")
        window.navigationBarColor = Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.navigationBarDividerColor = Color.TRANSPARENT
        }

        //设置沉浸后专栏栏和导航字体的颜色，
        ViewCompat.getWindowInsetsController(findViewById<FrameLayout>(android.R.id.content))?.let { controller ->
            controller.isAppearanceLightStatusBars = true
            controller.isAppearanceLightNavigationBars = true
            controller.hide(WindowInsetsCompat.Type.statusBars())
        }
    }
}