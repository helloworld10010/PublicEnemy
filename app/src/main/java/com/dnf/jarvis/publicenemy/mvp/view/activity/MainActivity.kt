package com.dnf.jarvis.publicenemy.mvp.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dnf.jarvis.publicenemy.R
import com.umeng.socialize.UMShareAPI
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import android.view.MenuItem
import com.dnf.jarvis.publicenemy.mvp.view.adapter.MainPagerAdapter
import com.dnf.jarvis.publicenemy.mvp.view.fragment.MessageFragment
import com.dnf.jarvis.publicenemy.mvp.view.fragment.WorldFragment
import com.dnf.jarvis.publicenemy.utils.setupActionBar
import com.dnf.jarvis.publicenemy.utils.showSnackBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBar(R.id.toolbar){
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayHomeAsUpEnabled(true)
        }

        drawerLayout = drawer_layout.apply {
            setStatusBarBackground(R.color.colorPrimaryDark)
        }

        val listFragments = arrayListOf(WorldFragment(), MessageFragment())
        viewpager.adapter = MainPagerAdapter(supportFragmentManager, arrayListOf("世界","消息"),listFragments)
        tabLayout.setupWithViewPager(viewpager)


        setupDrawerContent()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId){
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
            R.id.search -> drawerLayout.showSnackBar("搜索")
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_button_toolbar,menu)
        return true
    }

    /**
     * 侧边导航点击
     */
    private fun setupDrawerContent() {
        main_nav_view.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.showSnackBar(menuItem.title.toString())
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }

    /**
     * qq&微博 登录或分享
     */
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data)
//    }
}
