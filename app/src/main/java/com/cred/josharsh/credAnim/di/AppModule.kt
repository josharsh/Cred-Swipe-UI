package com.cred.josharsh.credAnim.di

import com.cred.josharsh.credAnim.businessLogic.SwipeAnimationBusinessLogic
import com.cred.josharsh.credAnim.businessLogic.SwipeAnimationBusinessLogicType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSwipeAnimationBusinessLogic(): SwipeAnimationBusinessLogicType {
        return SwipeAnimationBusinessLogic()
    }
}