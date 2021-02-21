package com.mars.ai1.data.repository.user

import com.mars.ai1.data.db.users.UsersDataSource
import com.mars.ai1.data.db.users.entities.UserEntity
import com.mars.ai1.data.repository.user.models.User
import com.mars.ai1.data.storage.UserStorage
import javax.inject.Inject

interface UserRepository {
    suspend fun loginUser(userName: String)
}

class UserRepositoryImpl @Inject constructor(
    private val usersDataSource: UsersDataSource,
    private val userStorage: UserStorage
) : UserRepository {
    override suspend fun loginUser(userName: String) {
        val user = usersDataSource.loginUser(UserEntity(name = userName))
        userStorage.currentUser = User(user.id!!, user.name)
    }

}