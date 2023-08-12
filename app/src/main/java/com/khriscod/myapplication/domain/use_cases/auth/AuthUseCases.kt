package com.khriscod.myapplication.domain.use_cases.auth

data class AuthUseCases (
    val getCurrentUser: GetCurrentUser,
    val login: Login
)