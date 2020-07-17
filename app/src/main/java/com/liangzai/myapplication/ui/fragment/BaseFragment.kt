package com.liangzai.myapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.orhanobut.logger.Logger
import com.socks.library.KLog
import com.socks.library.KLogUtil


/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020/7/17
 * 描述:
 *       1.常规Fragment父类
 * 疑惑：
 *      1.setUserVisibleHint不执行，在vp中执行，在默认中不会执行 -- 测试验证通过
 */
abstract class BaseFragment : Fragment() {
    //控件是否加载
    var isViewPrepared:Boolean = false

    var rootView:View ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("tag","当前线程${Thread.currentThread().name} + 当前类名${javaClass.simpleName} " + " onCreate")
        KLog.d("tag","当前线程${Thread.currentThread().name} + 当前类名${javaClass.simpleName} " + " onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(null == rootView){
            rootView = layoutInflater.inflate(getLayoutResources(),container,false)
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        isViewPrepared = true
        lazyLoad()
    }

    private fun lazyLoad() {
        KLog.d("tag","当前线程${Thread.currentThread().name} "  + " isViewPrepared "+ isViewPrepared)
        if(!isViewPrepared){
            return
        }
        lazyLoadData()
        //恢复默认状态
        isViewPrepared = false
    }

    //默认的加载数据函数，子View可重写
    private fun lazyLoadData() {
//        KLog.d("tag","当前线程${Thread.currentThread().name} " + " lazyLoadData")
        Logger.d("tag","当前线程${Thread.currentThread().name} " + " lazyLoadData")
    }


    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        KLog.e("tag","onHiddenChanged  " + hidden)
    }

    //定义每个界面布局的View
    abstract fun getLayoutResources(): Int

    open fun initView(){}
}