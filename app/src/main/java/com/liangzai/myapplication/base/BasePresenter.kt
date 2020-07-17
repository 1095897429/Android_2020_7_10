package com.liangzai.myapplication.base

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020/7/17
 * 描述:
 *      1.所有业务处理的父类
 * 职责：
 *      1.每个界面具体的业务逻辑处理
 *      2.比如获取数据 -- 业务逻辑开始
 */
interface BasePresenter {
    fun start()
}