package com.mars.ai1.data.storage

import com.mars.ai1.data.repository.user.models.User
import javax.inject.Inject

interface UserStorage {
    var currentUser: User?
}

class UserStorageImpl @Inject constructor() : UserStorage {
    override var currentUser: User? = null
}