package com.dnf.jarvis.publicenemy.mvp.view.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dnf.jarvis.publicenemy.R
import com.dnf.jarvis.publicenemy.mvp.bean.WantedTopic
import com.dnf.jarvis.publicenemy.mvp.contract.WorldContract
import com.dnf.jarvis.publicenemy.mvp.view.adapter.WantedTopicAdapter

class WorldFragment : Fragment(), WorldContract.IWorldView,SwipeRefreshLayout.OnRefreshListener {

    override fun showWantedTopics() {

    }

    override fun showEmpty() {
    }

    override fun showLoadingIndicator(active: Boolean) {
    }

    override fun showLoadingWantedError() {
    }

    override fun showNoWanted() {
    }

    override fun showWantedTopicDetailUi(topicId: String) {
    }

    /**
     *  下拉刷新时回调
     */
    override fun onRefresh() {
        wantedTopicMainAdapter.setEnableLoadMore(false)
        Handler().postDelayed({
            wantedTopicMainAdapter.setNewData(vData)
            swipeRefresh.isRefreshing = false
            wantedTopicMainAdapter.setEnableLoadMore(true)
        },1500)
    }

    override var presenter: WorldContract.IWorldPresenter
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    private val vData = arrayListOf(
        WantedTopic(
            "被骗300w",
            "http://news.chinaxiaokang.com/uploads/image/20171009/1507520519585948.jpg",
            "林依晨",
            "",
            2
        ),
        WantedTopic("被骗300w", "http://qimg.hxnews.com/2017/0925/1506321411292.jpg", "胡歌", "", 5),
        WantedTopic("被骗300w", "http://p1.pstatp.com/large/1f860004c339f4b0a43b", "秦始皇", "", 7),
        WantedTopic("被骗300w", "http://upload.morningpost.com.cn/2015/0129/1422528804511.jpg", "林志玲", "", 6),
        WantedTopic(
            "被骗300w",
            "http://5b0988e595225.cdn.sohucs.com/images/20180306/e8a8efc671d44a5691986dc1c3e102c5.jpeg",
            "朴信惠",
            "",
            18
        ),
        WantedTopic(
            "被骗300w",
            "http://hbimg.b0.upaiyun.com/6e2d8fe30d3bbd99bbd90529cfbbba6c6c42a2f43ca05-WJD6MP",
            "杨幂",
            "",
            18
        )
    )

    private lateinit var wantedTopicMainAdapter: WantedTopicAdapter
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        wantedTopicMainAdapter = WantedTopicAdapter(activity as Context, R.layout.world_item, vData)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_world_layout, container, false)
        with(root) {
            val recycle = findViewById<RecyclerView>(R.id.recycleView)
            recycle.adapter = wantedTopicMainAdapter
            recycle.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            wantedTopicMainAdapter.disableLoadMoreIfNotFullPage()
            wantedTopicMainAdapter.setOnLoadMoreListener {
                recycle.post {
                    wantedTopicMainAdapter.addData(vData)
                    wantedTopicMainAdapter.loadMoreComplete()
                }

            }

            swipeRefresh = findViewById(R.id.swipeRefresh)
            swipeRefresh.setOnRefreshListener(this@WorldFragment)

        }
        return root
    }

}