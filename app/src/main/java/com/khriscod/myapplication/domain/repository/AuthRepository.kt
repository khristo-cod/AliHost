package com.khriscod.myapplication.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.khriscod.myapplication.domain.model.Response

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login (email: String, password: String): Response<FirebaseUser>
}