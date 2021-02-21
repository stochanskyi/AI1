package com.mars.ai1.data.db.users

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mars.ai1.data.db.users.entities.UserEntity

@Dao
interface UsersDao {

    @Insert
    suspend fun addUser(user: UserEntity) : Long

    @Query("SELECT * FROM users WHERE name=:name")
    suspend fun findUserByName(name: String): UserEntity?

}