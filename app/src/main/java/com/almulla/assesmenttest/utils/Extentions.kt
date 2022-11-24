package com.almulla.assesmenttest.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

const val USER_NAME = "user_name"
const val IS_LOGIN = "is_login"
const val SELECTED_LANGUAGE_IS_ENG = "selected_language"


public val Context.getPreferences: SharedPreferences
    get() {
        return PreferenceManager.getDefaultSharedPreferences(this)
    }

public fun SharedPreferences.clear() {
    apply(getEditor().clear())
}

public fun SharedPreferences.putBoolean(key: String, value: Boolean) {
    apply(getEditor().putBoolean(key, value))
}


public fun SharedPreferences.putString(key: String, value: String?) {
    apply(getEditor().putString(key, value))
}


public fun SharedPreferences.remove(key: String) {
    apply(getEditor().remove(key))
}


private fun SharedPreferences.getEditor(): SharedPreferences.Editor {
    return this.edit()
}

private fun SharedPreferences.apply(editor: SharedPreferences.Editor) {
    editor.apply()
}

fun Context.setIsLogin(has: Boolean) {
    return getPreferences.putBoolean(IS_LOGIN, has)
}

fun Context.isLogin(): Boolean {
    return getPreferences.getBoolean(IS_LOGIN, false)
}

fun Context.setUserName(name: String) {
    return getPreferences.putString(USER_NAME, name)
}

fun Context.getUserName(): String? {
    return getPreferences.getString(USER_NAME, "")
}

fun Context.setIsEnglishLangSelected(language: String) {
    return getPreferences.putString(SELECTED_LANGUAGE_IS_ENG, language)
}

fun Context.isEnglishLangSelected(): String? {
    return getPreferences.getString(SELECTED_LANGUAGE_IS_ENG, "en")
}

fun Context.clearUserData() {
    getPreferences.remove(IS_LOGIN)
    getPreferences.remove(USER_NAME)
    getPreferences.remove(SELECTED_LANGUAGE_IS_ENG)

}
