package com.example.kotlin42.presentation.data

import android.content.Context

class SharedPreferences(private val context: Context) {

    private val preferenceHelper = context.getSharedPreferences("name", Context.MODE_PRIVATE)

    var userName: String?
        get() {
           return preferenceHelper.getString(NAME_KEY, "")
        }
        set(value) {
            preferenceHelper.edit().putString(NAME_KEY, value).apply()
        }

    var userPassword: String?
        get() {
            return preferenceHelper.getString(PASSWORD, "")
        }
        set(value) {
            preferenceHelper.edit().putString(PASSWORD, value).apply()
        }

    var userMail: String?
        get() {
            return preferenceHelper.getString(MAIL, "")
        }
        set(value) {
            preferenceHelper.edit().putString(MAIL, value).apply()
        }

    companion object{
        private val NAME_KEY = "user_name"
        private val PASSWORD = "user_password"
        private val MAIL = "user_mail"
    }
}