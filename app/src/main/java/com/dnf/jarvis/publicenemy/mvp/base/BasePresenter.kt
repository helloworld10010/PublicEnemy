package com.dnf.jarvis.publicenemy.mvp.base

import android.content.Context

open class BasePresenter<V : IBaseView,M : BaseModel>(var mContext: Context,var mView: V?, var mModel: M?) {

    fun onDestroy(){
        mModel?.onDestroy()
    }
}