package com.dnf.jarvis.publicenemy.mvp.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dnf.jarvis.publicenemy.R
import android.widget.Toast
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.mContext
import com.umeng.socialize.bean.SHARE_MEDIA
import com.umeng.socialize.UMAuthListener
import com.umeng.socialize.UMShareAPI
import kotlinx.android.synthetic.main.login_activity.*


class LoginActivity : AppCompatActivity() {

    var umAuthListener: UMAuthListener = object : UMAuthListener {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        override fun onStart(platform: SHARE_MEDIA) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        override fun onComplete(platform: SHARE_MEDIA, action: Int, data: Map<String, String>) {

            Toast.makeText(mContext, "成功了", Toast.LENGTH_LONG).show()

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        override fun onError(platform: SHARE_MEDIA, action: Int, t: Throwable) {

            Toast.makeText(mContext, "失败：" + t.message, Toast.LENGTH_LONG).show()
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        override fun onCancel(platform: SHARE_MEDIA, action: Int) {
            Toast.makeText(mContext, "取消了", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        QQbutton.setOnClickListener {
            UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, umAuthListener);
        }
    }
}