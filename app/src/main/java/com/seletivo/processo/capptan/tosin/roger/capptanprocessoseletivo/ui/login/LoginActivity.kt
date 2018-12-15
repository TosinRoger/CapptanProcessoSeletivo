package com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.R
import com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        configView()
    }

    private fun configView() {
        editText_login_pass.setOnEditorActionListener { v, actionId, event ->
            button_login_enter.performClick()
        }

        button_login_enter.setOnClickListener {
            val user = editText_login_user.text.toString()
            val pass = editText_login_pass.text.toString()
            presenter.makeLogin(user, pass)
        }
        button_login_register.setOnClickListener {
            val user = editText_login_user.text.toString()
            val pass = editText_login_pass.text.toString()
            presenter.chuncho(user, pass)
            showMessageError("Estou salvando diretamento usuario e senha, pois nao conseguirei implementar a tela de registrar")
        }
    }

    fun showErrorEmail(show: Boolean, idTextError: Int) {
        if (show)
            editText_login_user.error = getString(idTextError)
        else
            editText_login_user.error = null
    }

    fun showErrorPass(show: Boolean, idTextError: Int) {
        if (show)
            editText_login_pass.error = getString(idTextError)
        else
            editText_login_pass.error = null
    }

    fun showMessageError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    fun openMain(userId: Long) {
        val intent = Intent(this, MainActivity::class.java)
        val args = Bundle()
        args.putLong("userId", userId)
        startActivity(intent)
        finish()
    }

}
