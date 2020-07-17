package com.liangzai.myapplication.mvp.presenter

import android.content.Context
import com.liangzai.myapplication.mvp.contract.HomeContract

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020/7/17
 * 描述:
 *      1.请求主页数据
 */
class HomePresenter(context: Context,view: HomeContract.View):HomeContract.Presenter {

    var mContext : Context? = null
    var mView : HomeContract.View? = null


    init {
        mContext = context
        mView = view
    }

    override fun requestData() {
    }

    override fun start() {

    }
}