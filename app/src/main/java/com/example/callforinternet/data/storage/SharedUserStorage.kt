package com.example.callforinternet.data.storage

import android.content.Context
import com.example.callforinternet.data.model.User
import com.example.callforinternet.domain.model.UserName

private const val SHARED_PREF_NAME = "shared_pref_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"

class SharedUserStorage(private val context: Context) : SharedStorage {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)


    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        return true
    }

    override fun getUser(): User {
        return User(
            firstName = sharedPreferences.getString(KEY_FIRST_NAME, "def") ?: "def",
            lastName = "dsds"
        )
    }
}