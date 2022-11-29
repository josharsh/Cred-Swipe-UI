package com.cred.josharsh.credAnim.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel : ViewModel() {
    private val _loading: MutableState<Boolean> = mutableStateOf(false)
    val loading: State<Boolean>
        get() = _loading

    open fun apiScope(
        dispatcher: CoroutineDispatcher? = null,
        block: suspend () -> Unit
    ) {
        viewModelScope.launch(dispatcher ?: EmptyCoroutineContext) {
            try {
                setLoading(true)
                block()
            } catch (ex: Exception) {
                ex.printStackTrace()
                //MonitoringService.captureException(exception = ex)
            } finally {
                setLoading(false)
            }
        }
    }

    fun setLoading(isLoading: Boolean) {
        _loading.value = isLoading
    }
}