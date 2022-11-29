package com.cred.josharsh.credAnim.services

import com.cred.josharsh.credAnim.models.SwipeResult
import com.cred.josharsh.credAnim.repositories.SwipeAnimationRepository

class SwipeAnimationService {
    suspend fun getSwipeResults(path: String): SwipeResult{
        return SwipeAnimationRepository().getSwipeResults(path)

    }
}