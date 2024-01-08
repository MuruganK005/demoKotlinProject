package com.example.model

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Getter
@Setter
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "username", nullable = false)
    val username: String="",

    @Column(name = "email", nullable = false)
    val email: String=""
)