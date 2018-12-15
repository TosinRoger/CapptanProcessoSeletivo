package com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.ui.login

import com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.database.FakeDatabase
import com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.model.User

class LoginRepository(val presenter: LoginPresenter) {
    val db = FakeDatabase()


    fun saveUser(user: User) {
        db.saveUser(user)
    }

    fun saveUser(email: String, pass: String) {
        var user = User(email, pass.toInt())
        db.saveUser(user)
    }

    fun fetchUser(userId: Int): User? {
        return db.fetchUser(userId.toString())
    }

    fun fetchUser(email: String, pass: String): User? {
        return db.fetchUser(email, pass)
    }
}