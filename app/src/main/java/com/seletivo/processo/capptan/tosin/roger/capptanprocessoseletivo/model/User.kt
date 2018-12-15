package com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.model

import java.util.*

data class User(val email: String, val password: Int) {
    @Transient
    val key = "user"
    val id = Calendar.getInstance().time.time
}