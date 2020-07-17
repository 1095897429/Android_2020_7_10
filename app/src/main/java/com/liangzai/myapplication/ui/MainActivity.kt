package com.liangzai.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.liangzai.myapplication.R
import com.liangzai.myapplication.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var homeFragment: HomeFragment? = null
    var findFragment: FindFragment? = null
    var hotFragemnt: HotFragment? = null
    var mineFragment: MineFragment? = null
    var currentFragment:Fragment?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        setRadioButton()
    }

    private fun setRadioButton() {
        rb_home.isChecked = true
        rb_home.setTextColor(resources.getColor(R.color.black))
        rb_home.setOnClickListener(this)
        rb_find.setOnClickListener(this)
        rb_hot.setOnClickListener(this)
        rb_mine.setOnClickListener(this)
    }

    private fun initFragment() {
        if(currentFragment == null){
            homeFragment = HomeFragment()
        }
        currentFragment = homeFragment
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.add(R.id.fl_content, homeFragment!!)
        fragmentTrans.commit()
    }

    override fun onClick(v: View?) {
        clearState()
        when(v?.id){
            R.id.rb_home -> {
                rb_home.isChecked = true
                rb_home.setTextColor(resources.getColor(R.color.black))

                if (null == homeFragment) {
                    homeFragment = HomeFragment()
                }

                switchFragment(homeFragment!!)
            }
        }
    }

    /** 切换 Fragment */
    private fun switchFragment(fragment: Fragment) {
        if(currentFragment != fragment){
            var  transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.hide(currentFragment!!)
            transaction.commit()
        }
    }

    private fun clearState() {
        rg_root.clearCheck()
        rb_home.setTextColor(resources.getColor(R.color.gray))
        rb_mine.setTextColor(resources.getColor(R.color.gray))
        rb_hot.setTextColor(resources.getColor(R.color.gray))
        rb_find.setTextColor(resources.getColor(R.color.gray))
    }
}