package com.dnf.jarvis.publicenemy.mvp.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import java.lang.RuntimeException

abstract class BaseActivity<T : BasePresenter<*, *>> : AppCompatActivity() {
    var mContext: Context? = null
    var mPresenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        if (setContentViewId() != 0) {
            setContentView(setContentViewId())
        } else {
            throw RuntimeException("layoutResID == -1 have u create your layout?")
        }
        createPresenter()
        ButterKnife.bind(this)
        initView()
    }

    protected fun initView() {

    }

    fun startActivity(className: Class<*>) {
        val intent = Intent(mContext, className);
        startActivity(intent)
    }

    fun startActivity(className: Class<*>, bundle: Bundle) {
        val intent = Intent(mContext, className)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    abstract fun createPresenter()

    abstract fun setContentViewId(): Int

    override fun onDestroy() {
        super.onDestroy()

        mPresenter?.onDestroy()

    }
}