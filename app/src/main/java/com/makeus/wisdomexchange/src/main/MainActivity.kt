package com.makeus.wisdomexchange.src.main

import android.os.Bundle
import com.makeus.wisdomexchange.R
import com.makeus.wisdomexchange.src.BaseActivity
import com.makeus.wisdomexchange.src.main.feed.FeedFragment
import com.makeus.wisdomexchange.src.main.home.HomeFragment
import com.makeus.wisdomexchange.src.main.my_page.MyPageFragment
import com.makeus.wisdomexchange.src.main.notification.NotificationFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var homeFragment: HomeFragment? = null
    private var notificationFragment: NotificationFragment? = null
    private var feedFragment: FeedFragment? = null
    private var myPageFragment: MyPageFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        onMoveHomeFragment()
    }

    private fun initView() {
        bot_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item_tab_home -> onMoveHomeFragment()
                R.id.item_tab_notification -> onMoveNotificationFragment()
                R.id.item_tab_feed -> onMoveFeedFragment()
                R.id.item_tab_my_page -> onMoveMyPageFragment()
            }
            true
        }
    }

    private fun onMoveHomeFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance()
            transaction.add(R.id.cl_main_screen, homeFragment!!)
        }

        if (homeFragment != null) transaction.show(homeFragment!!)
        if (notificationFragment != null) transaction.hide(notificationFragment!!)
        if (feedFragment != null) transaction.hide(feedFragment!!)
        if (myPageFragment != null) transaction.hide(myPageFragment!!)

        transaction.commitAllowingStateLoss()
    }

    private fun onMoveNotificationFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        if (notificationFragment == null) {
            notificationFragment = NotificationFragment.newInstance()
            transaction.add(R.id.cl_main_screen, notificationFragment!!)
        }

        if (homeFragment != null) transaction.hide(homeFragment!!)
        if (notificationFragment != null) transaction.show(notificationFragment!!)
        if (feedFragment != null) transaction.hide(feedFragment!!)
        if (myPageFragment != null) transaction.hide(myPageFragment!!)

        transaction.commitAllowingStateLoss()
    }

    private fun onMoveFeedFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        if (feedFragment == null) {
            feedFragment = FeedFragment.newInstance()
            transaction.add(R.id.cl_main_screen, feedFragment!!)
        }

        if (homeFragment != null) transaction.hide(homeFragment!!)
        if (notificationFragment != null) transaction.hide(notificationFragment!!)
        if (feedFragment != null) transaction.show(feedFragment!!)
        if (myPageFragment != null) transaction.hide(myPageFragment!!)

        transaction.commitAllowingStateLoss()
    }

    private fun onMoveMyPageFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        if (myPageFragment == null) {
            myPageFragment = MyPageFragment.newInstance()
            transaction.add(R.id.cl_main_screen, myPageFragment!!)
        }

        if (homeFragment != null) transaction.hide(homeFragment!!)
        if (notificationFragment != null) transaction.hide(notificationFragment!!)
        if (feedFragment != null) transaction.hide(feedFragment!!)
        if (myPageFragment != null) transaction.show(myPageFragment!!)

        transaction.commitAllowingStateLoss()
    }
}