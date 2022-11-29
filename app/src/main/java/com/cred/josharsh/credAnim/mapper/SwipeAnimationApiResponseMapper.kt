package com.cred.josharsh.credAnim.mapper

import com.cred.josharsh.credAnim.models.SwipeResult
import com.google.gson.Gson

interface Mapper<FROM, TO> {
    fun mapFrom(from: FROM): TO
}

class SwipeAnimationApiResponseMapper : Mapper<String, SwipeResult> {
    override fun mapFrom(from: String): SwipeResult {
        var gson = Gson()
        return gson.fromJson(from, SwipeResult::class.java)
    }
}
