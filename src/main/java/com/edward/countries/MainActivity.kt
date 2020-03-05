package com.edward.countries


class MainActivity : SingleFragmentActivity() {
    override fun createFragment() = MainFragment.newInstance()
}