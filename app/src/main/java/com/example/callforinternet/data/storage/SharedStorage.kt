package com.example.callforinternet.data.storage

import com.example.callforinternet.data.model.User

interface SharedStorage {
    fun save(user: User):Boolean

    fun getUser(): User
}