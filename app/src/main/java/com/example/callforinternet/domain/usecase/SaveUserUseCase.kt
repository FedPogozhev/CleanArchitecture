package com.example.callforinternet.domain.usecase

import com.example.callforinternet.domain.model.SaveUserNameParam
import com.example.callforinternet.domain.repository.UserRepository

class SaveUserUseCase(private val userRepository: UserRepository) {
    fun execute(saveUserNameParam: SaveUserNameParam):Boolean {
        return userRepository.saveName(saveUserNameParam)
    }
}