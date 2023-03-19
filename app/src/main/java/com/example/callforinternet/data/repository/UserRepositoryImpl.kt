package com.example.callforinternet.data.repository

import android.content.Context
import com.example.callforinternet.data.model.User
import com.example.callforinternet.data.storage.SharedStorage
import com.example.callforinternet.domain.model.SaveUserNameParam
import com.example.callforinternet.domain.model.UserName
import com.example.callforinternet.domain.repository.UserRepository



class UserRepositoryImpl(private val sharedStorage: SharedStorage): UserRepository {


    override fun saveName(userName: SaveUserNameParam): Boolean{
        return sharedStorage.save(
            User(
                firstName = userName.name,
                lastName = "lastName"
            )
        )
    }

    override fun getUserName(): UserName{
       return UserName(
           firstName = sharedStorage.getUser().firstName,
           lastName = sharedStorage.getUser().lastName
       )
    }


}