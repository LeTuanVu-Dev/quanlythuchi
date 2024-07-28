package com.tuanvu.quanlichitieu.future.activity

import com.tuanvu.quanlichitieu.base.BaseActivity
import com.tuanvu.quanlichitieu.databinding.ActivityMainBinding
import com.tuanvu.quanlichitieu.future.fragment.SettingFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun createView() {
        addFragment(SettingFragment.instance())
    }

}