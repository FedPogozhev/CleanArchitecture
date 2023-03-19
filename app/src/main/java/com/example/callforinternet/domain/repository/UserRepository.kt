package com.example.callforinternet.domain.repository

import com.example.callforinternet.domain.model.SaveUserNameParam
import com.example.callforinternet.domain.model.UserName

interface UserRepository {
    fun saveName(userNameParam: SaveUserNameParam): Boolean

    fun getUserName(): UserName
}