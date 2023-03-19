package com.example.callforinternet.domain.usecase

import com.example.callforinternet.domain.model.UserName
import com.example.callforinternet.domain.repository.UserRepository

class GetUserUseCase(private val repository: UserRepository) {
    fun execute() : UserName {
        return repository.getUserName()
    }
}