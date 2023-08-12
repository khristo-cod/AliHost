package com.khriscod.myapplication.di

import com.google.firebase.auth.FirebaseAuth
import com.khriscod.myapplication.data.repository.AuthRepositoryImpl
import com.khriscod.myapplication.domain.repository.AuthRepository
import com.khriscod.myapplication.domain.use_cases.auth.AuthUseCases
import com.khriscod.myapplication.domain.use_cases.auth.GetCurrentUser
import com.khriscod.myapplication.domain.use_cases.auth.Login
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideAuthUseCases(repository:AuthRepository)= AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository)
    )
}