package com.cred.josharsh.credAnim.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import com.cred.josharsh.credAnim.businessLogic.SwipeAnimationBusinessLogicType
import com.cred.josharsh.credAnim.constants.ApiCases
import com.cred.josharsh.credAnim.constants.States
import com.cred.josharsh.credAnim.constants.SwipeResultMessage
import com.cred.josharsh.credAnim.models.SwipeResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SwipeAnimationViewModel @Inject constructor(
    private val businessLogic: SwipeAnimationBusinessLogicType
) : BaseViewModel() {

    private var _swipeState: MutableState<States> = mutableStateOf(States.TOP)
    val swipeState: MutableState<States>
        get() = _swipeState

    private var _swipeResultMessage: MutableLiveData<String> = MutableLiveData("")
    val swipeResultMessage
        get() = _swipeResultMessage.value

    val checkedState: MutableState<Boolean> = mutableStateOf(true)

    private var _swipeResult: MutableLiveData<SwipeResult?> = MutableLiveData(null)
    val swipeResult: MutableLiveData<SwipeResult?>
        get() = _swipeResult

    private var _shouldGetSwipeResult: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldGetSwipeResult: MutableLiveData<Boolean>
        get() = _shouldGetSwipeResult

    fun setSwipeResultMessage(success: Boolean) {
        if (success) _swipeResultMessage.value = SwipeResultMessage.SuccessCase.message
    }

    private fun setShouldGetSwipeResult(shouldGet: Boolean) {
        _shouldGetSwipeResult.value = shouldGet
    }

    private fun getSwipeResult() {
        when (swipeState.value) {
            States.BOTTOM -> setShouldGetSwipeResult(true)
        }
    }

    fun setSwipeState(state: States) {
        _swipeState.value = state
        getSwipeResult()
    }

    fun getSwipeResult(checkedState: Boolean) {
        apiScope {
            if (checkedState) {
                _swipeResult.value = businessLogic.getSwipeResults(ApiCases.SuccessCase.path)

            } else
                _swipeResult.value = businessLogic.getSwipeResults(ApiCases.FailureCase.path)
        }
    }
}