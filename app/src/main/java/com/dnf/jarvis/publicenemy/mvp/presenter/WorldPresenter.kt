package com.dnf.jarvis.publicenemy.mvp.presenter

import com.dnf.jarvis.publicenemy.mvp.bean.WantedTopic
import com.dnf.jarvis.publicenemy.mvp.contract.WorldContract
import com.dnf.jarvis.publicenemy.mvp.model.Repository

class WorldPresenter(val worldRepository: Repository, val worldView:WorldContract.IWorldView) : WorldContract.IWorldPresenter {

    init {
        worldView.presenter = this
    }

    override fun loadWantedTopics() {
    }

    override fun openTopicDetails(requestedTopic: WantedTopic) {
    }

    override fun start() {
    }
}