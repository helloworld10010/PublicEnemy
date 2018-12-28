package com.dnf.jarvis.publicenemy.mvp.contract

import com.dnf.jarvis.publicenemy.mvp.base.IBasePresenter
import com.dnf.jarvis.publicenemy.mvp.base.IBaseView
import org.w3c.dom.Entity

interface CLogin {
    interface IPLogin : IBasePresenter{
        fun login()
    }
    interface IVLogin : IBaseView{
        fun vLoginSuccess(bean:Entity)
        fun vLoginError(reason:String)
    }
}