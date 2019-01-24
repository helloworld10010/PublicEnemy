package com.dnf.jarvis.publicenemy.mvp.view.adapter

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dnf.jarvis.publicenemy.DevMvpApplication
import com.dnf.jarvis.publicenemy.R
import com.dnf.jarvis.publicenemy.mvp.bean.WantedTopic

class WantedTopicAdapter(val context: Context, layoutResId:Int, listData:List<WantedTopic>) : BaseQuickAdapter<WantedTopic,BaseViewHolder>(layoutResId,listData){

    override fun convert(helper: BaseViewHolder, item: WantedTopic) {
        helper.setText(R.id.titleText,item.title)
            .setText(R.id.author,item.author)
            .setText(R.id.reportCount,item.eggs.toString())

        Glide.with(context)
            .load(item.wantedImage)
            .into(helper.getView(R.id.wantedImage) as ImageView)
    }
}
