package com.example.yesdoktest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.yesdoktest.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() , MyHandler{

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        this.viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        binding.viewModel = viewModel
        binding.handler = this

        viewModel.getLogInResult().observe(this, Observer { result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onLoginAndRegisterClicked() {
        viewModel.performValidation()
    }
}