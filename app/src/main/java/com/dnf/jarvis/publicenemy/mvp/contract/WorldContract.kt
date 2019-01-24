package com.dnf.jarvis.publicenemy.mvp.contract

import com.dnf.jarvis.publicenemy.mvp.base.IBasePresenter
import com.dnf.jarvis.publicenemy.mvp.base.IBaseView
import com.dnf.jarvis.publicenemy.mvp.bean.WantedTopic

interface WorldContract {

    interface IWorldView : IBaseView<IWorldPresenter>{

        fun showWantedTopics()

        fun showEmpty()

        fun showLoadingIndicator(active:Boolean)

        fun showLoadingWantedError()

        fun showNoWanted()

        fun showWantedTopicDetailUi(topicId:String)
    }

    interface IWorldPresenter : IBasePresenter{

        fun loadWantedTopics()

        fun openTopicDetails(requestedTopic: WantedTopic)

    }
}