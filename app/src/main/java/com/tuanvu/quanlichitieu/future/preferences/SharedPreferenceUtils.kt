package com.tuanvu.quanlichitieu.future.preferences
import com.tuanvu.quanlichitieu.future.application.MyApplication


object SharedPreferenceUtils {
    private const val FIRST_OPEN_APP = "FIRST_OPEN_APP"
    private const val PREF_CNT_OPEN_APP = "PREF_CNT_OPEN_APP"
    private const val KEY_USER = "KEY_USER"


    var firstOpenApp: Boolean
        get() = MyApplication.instanceSharePreference.getValueBool(FIRST_OPEN_APP, false)
        set(value) = MyApplication.instanceSharePreference.setValueBool(FIRST_OPEN_APP, value)

    var cntOpenApp: Int
        get() = MyApplication.instanceSharePreference.getIntValue(PREF_CNT_OPEN_APP, 0)
        set(value) = MyApplication.instanceSharePreference.setIntValue(PREF_CNT_OPEN_APP, value)

    var keyUserLogin: Long
        get() =
            MyApplication.instanceSharePreference.getLongValue(KEY_USER, -1)
        set(value) = MyApplication.instanceSharePreference.setLongValue(KEY_USER, value)
}