package com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.seletivo.processo.capptan.tosin.roger.capptanprocessoseletivo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configView()
    }

    private fun configView() {
        toolbar.title = getString(R.string.app_name)
        setSupportActionBar(toolbar)
    }
}
