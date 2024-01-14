package com.example.service

// UserService.kt
import com.example.model.User
import com.example.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUserById(id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun updateUser(id: Long, newUser: User): User? {
        return userRepository.findById(id).map { existingUser ->
            val updatedUser = existingUser.copy(
                username = newUser.username,
                email = newUser.email
            )
            userRepository.save(updatedUser)
        }.orElse(null)
    }

    fun deleteUser(id: Long) {
        if (userRepository.findById(id).isEmpty()) {
            throw IllegalArgumentException("User with id $id does not exist")
        }
        userRepository.delete(userRepository.findById(id).get())
    }
}
