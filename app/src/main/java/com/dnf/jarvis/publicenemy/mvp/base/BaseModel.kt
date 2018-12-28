package com.dnf.jarvis.publicenemy.mvp.base

import com.dnf.jarvis.publicenemy.api.EnemyService
import io.reactivex.disposables.CompositeDisposable

open class BaseModel {
    val mDisposable:CompositeDisposable = CompositeDisposable()

//    fun createApi():EnemyService{
//
//    }
    fun onDestroy(){
        mDisposable.dispose()
        mDisposable.clear()
    }
}