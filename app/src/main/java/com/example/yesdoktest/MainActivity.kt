package com.example.yesdoktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.yesdoktest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyHandler {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        this.viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.handler = this

        viewModel.getLogInResult().observe(this, Observer { result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        })

        binding.bLoginToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun onLoginAndRegisterClicked() {
        viewModel.performValidation()
    }

}