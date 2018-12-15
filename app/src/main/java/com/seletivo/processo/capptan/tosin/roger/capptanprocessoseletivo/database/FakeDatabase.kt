package com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.database

import android.content.Context
import com.google.gson.Gson
import com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.AppApplication
import com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.model.User

class FakeDatabase {
    private val sharedPreferences = AppApplication.context?.getSharedPreferences("FakePreferences", Context.MODE_PRIVATE)
    private val editor = sharedPreferences?.edit()

    fun saveUser(user: User) {
        val temp = Gson().toJson(user)
        saveData(user.key, temp)
    }

    fun fetchUser(userId: String): User? {
        val temp = Gson().fromJson<User>(getData(User("",0).key), User::class.java)
        return when {
            temp.id == userId.toLong() -> temp
            else -> null
        }
    }

    fun fetchUser(email: String, pass: String): User? {
        val temp = Gson().fromJson<User>(getData(User("",0).key), User::class.java)
        if (temp.email == email && temp.password == pass.toInt())
            return temp
        else
            return null
    }


    private fun saveData(key: String, data: String) {
        editor?.putString(key, data)
        editor?.commit()
    }

    fun getData(key: String): String {
        return  sharedPreferences?.getString(key, "") ?: ""
    }
}