package com.liangzai.myapplication.ui.fragment

import com.liangzai.myapplication.R
import com.liangzai.myapplication.mvp.contract.HomeContract
import com.liangzai.myapplication.mvp.model.HomeBean
import com.liangzai.myapplication.mvp.presenter.HomePresenter

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020/7/17
 * 描述:
 */
class HomeFragment : BaseFragment(), HomeContract.View {

     var homePresenter : HomePresenter? = null


    override fun setData(bean: HomeBean) {

    }

    override fun getLayoutResources(): Int {
        return R.layout.home_fragment
    }

    override fun initView() {
//        homePresenter = HomePresenter(context,this)
    }
}