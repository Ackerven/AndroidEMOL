package com.ackerven.adnroid.emol

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var kx:ImageButton
    private lateinit var pj:ImageButton
    private lateinit var sq:ImageButton
    private lateinit var dx:ImageButton
    private lateinit var hb:ImageButton
    private lateinit var ll:ImageButton
    private lateinit var sx:ImageButton
    private lateinit var yx:ImageButton
    private lateinit var mm:ImageButton
    private lateinit var wy:ImageButton
    private lateinit var xd:ImageButton
    private lateinit var avatar:ImageView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolBar()
        hideStatusBar()

        kx = findViewById(R.id.emoji_kx)
        pj = findViewById(R.id.emoji_pj)
        sq = findViewById(R.id.emoji_sq)
        dx = findViewById(R.id.emoji_dx)
        hb = findViewById(R.id.emoji_hb)
        ll = findViewById(R.id.emoji_ll)
        sx = findViewById(R.id.emoji_sx)
        yx = findViewById(R.id.emoji_yx)
        mm = findViewById(R.id.emoji_mm)
        wy = findViewById(R.id.emoji_wy)
        xd = findViewById(R.id.emoji_xd)
        setOnLongClick()

        //设置随机头像
        avatar = findViewById(R.id.avatar)
        setRandomAvatar();

    }

    private fun setRandomAvatar() {
        val typeArray = resources.obtainTypedArray(R.array.emoji)
        var stringArray = resources.getStringArray(R.array.emoji)
        val length = typeArray.length()
        val list:IntArray = IntArray(length)
        for(i in 0 until length) {
            val rid = typeArray.getResourceId(i, 0)
            list[i] = rid
        }
        avatar.setImageResource(list[(list.indices).random()]);
    }

    private fun showDetails(details:String?):Boolean {
        Toast.makeText(this, details, Toast.LENGTH_SHORT).show()
        return true
    }

    private fun setOnLongClick() {
        kx.setOnLongClickListener { showDetails("开心") }
        pj.setOnLongClickListener { showDetails("平静") }
        sq.setOnLongClickListener { showDetails("生气") }
        dx.setOnLongClickListener { showDetails("担心") }
        hb.setOnLongClickListener { showDetails("好棒") }
        ll.setOnLongClickListener { showDetails("流泪") }
        sx.setOnLongClickListener { showDetails("伤心") }
        yx.setOnLongClickListener { showDetails("悠闲") }
        mm.setOnLongClickListener { showDetails("迷茫") }
        wy.setOnLongClickListener { showDetails("无语") }
        xd.setOnLongClickListener { showDetails("心动") }
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