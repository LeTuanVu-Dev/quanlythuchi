package com.tuanvu.quanlichitieu.future.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tuanvu.quanlichitieu.base.BaseFragment
import com.tuanvu.quanlichitieu.databinding.FragmentSettingBinding
import com.tuanvu.quanlichitieu.future.activity.LoginActivity
import com.tuanvu.quanlichitieu.future.preferences.SharedPreferenceUtils


class SettingFragment : BaseFragment<FragmentSettingBinding>() {
    companion object {
        fun instance(): SettingFragment {
            return newInstance(SettingFragment::class.java)
        }
    }

    override fun initView() {
        onClick()
    }

    fun onClick() {
        binding.btnLogout.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        SharedPreferenceUtils.keyUserLogin = -1
        startActivity(Intent(requireContext(),LoginActivity::class.java))
        requireActivity().finish()
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSettingBinding {
        return FragmentSettingBinding.inflate(inflater, container, false)
    }
}