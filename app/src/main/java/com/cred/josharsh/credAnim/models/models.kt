package com.cred.josharsh.credAnim.models

import kotlinx.serialization.Serializable


@Serializable
data class SwipeResult(var success: Boolean? = false, var error: String? = null)
