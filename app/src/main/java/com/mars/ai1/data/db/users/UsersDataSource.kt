package com.mars.ai1.data.db.users

import com.mars.ai1.data.db.users.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface UsersDataSource {
    suspend fun loginUser(entity: UserEntity): UserEntity
}

class UserDataSourceImpl @Inject constructor(
    private val usersDao: UsersDao,
) : UsersDataSource {
    override suspend fun loginUser(entity: UserEntity): UserEntity {
        return withContext(Dispatchers.IO) {
            usersDao.findUserByName(entity.name) ?: run {
                val id = usersDao.addUser(entity).toInt()
                UserEntity(id, entity.name)
            }
        }
    }
}