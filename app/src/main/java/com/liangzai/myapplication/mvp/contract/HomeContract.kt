package com.liangzai.myapplication.mvp.contract

import com.liangzai.myapplication.base.BasePresenter
import com.liangzai.myapplication.base.BaseView
import com.liangzai.myapplication.mvp.model.HomeBean

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020/7/17
 * 描述:
 *  1.主界面界面的契约
 */
interface HomeContract {

    interface Presenter:BasePresenter{
        fun requestData()
    }

    interface View : BaseView<Presenter>{
        fun setData(bean: HomeBean)
    }
}