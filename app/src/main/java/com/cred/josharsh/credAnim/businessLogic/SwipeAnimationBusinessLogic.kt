package com.cred.josharsh.credAnim.businessLogic

import com.cred.josharsh.credAnim.models.SwipeResult
import com.cred.josharsh.credAnim.services.SwipeAnimationService

interface SwipeAnimationBusinessLogicType {
   suspend fun getSwipeResults(path: String): SwipeResult
}
class SwipeAnimationBusinessLogic: SwipeAnimationBusinessLogicType {
    override suspend fun getSwipeResults(path: String): SwipeResult {
        return SwipeAnimationService().getSwipeResults(path)
    }
}