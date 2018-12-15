package com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.ui.login

import com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.R

class LoginPresenter(val view: LoginActivity) {

    private val repository = LoginRepository(this)
    fun makeLogin(email: String, pass: String) {
        if (validateCredentials(email, pass)) {
            val user = repository.fetchUser(email, pass)
            if (user == null) {
                view.showMessageError("Usuário não encontrado")
            } else {
                view.openMain(user.id)
            }

        } else {
            // continue in login activity
        }
    }

    private fun validateCredentials(email: String, pass: String): Boolean {
        var itsOk = true

        if (email.isNullOrEmpty()) {
            view.showErrorEmail(true, R.string.user_empty)
            itsOk = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.showErrorEmail(true, R.string.user_invalid)
            itsOk = false
        } else
            view.showErrorEmail(false, 0)

        if (pass.isNullOrEmpty()) {
            view.showErrorPass(true, R.string.pass_empty)
            itsOk = false
        } else if (!Regex("[0-9]+").matches(pass)) {
            view.showErrorPass(true, R.string.pass_invalid)
            itsOk = false
        } else
            view.showErrorPass(false, 0)

        return itsOk
    }

    fun chuncho(email: String, pass: String) {
        repository.saveUser(email, pass)
    }

}