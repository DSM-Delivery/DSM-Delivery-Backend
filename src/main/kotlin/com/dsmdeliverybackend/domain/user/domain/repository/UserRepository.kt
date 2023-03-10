package com.dsmdeliverybackend.domain.user.domain.repository

import com.dsmdeliverybackend.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : CrudRepository<User, UUID> {

    fun findByAccountId(accountId: String) : User?

    fun existsByAccountId(accountId: String): Boolean

}