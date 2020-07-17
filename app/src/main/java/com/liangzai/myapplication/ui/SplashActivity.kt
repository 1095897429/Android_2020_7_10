package com.liangzai.myapplication.ui

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import androidx.appcompat.app.AppCompatActivity
import com.liangzai.myapplication.R
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020/7/16
 * 描述:
 */
class SplashActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置全屏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        initView()
        setAnimation()
    }

    private fun setAnimation() {
        val alpha = AlphaAnimation(0.1f,1f)
        alpha.duration = 1000
        //以view中心缩放
        val scale = ScaleAnimation(0.1f,1.0f,0.1f,1.0f,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f)
        scale.duration = 1000
        //集合
        var set = AnimationSet(true)
        set.addAnimation(alpha)
        set.addAnimation(scale)
        set.duration = 1000
        iv_icon_splash.startAnimation(set)
        set.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                val intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
    }

    private fun initView() {
        val font : Typeface = Typeface.createFromAsset(assets,"fonts/Lobster-1.4.otf")
        tv_name_english.typeface = font
        tv_english_intro.typeface = font
    }
}