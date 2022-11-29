package com.cred.josharsh.credAnim.repositories

import com.cred.josharsh.credAnim.models.SwipeResult
import com.cred.josharsh.credAnim.remoteDataSources.SwipeAnimationRemoteDataSource

class SwipeAnimationRepository {
    suspend fun getSwipeResults(path: String): SwipeResult {
        return SwipeAnimationRemoteDataSource().getSwipeResults(path)
    }
}