package com.mars.ai1.presentation.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.mars.ai1.databinding.ActivityLoginBinding
import com.mars.ai1.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityLoginBinding.inflate(layoutInflater).run {
            setContentView(root)
            initListeners(this)
            initObservers(this)
        }
    }

    private fun initObservers(binding: ActivityLoginBinding) {
        viewModel.navigateToQuestionsLiveData.observe(this) {
            MainActivity.start(this)
        }
        viewModel.isLoginEnabledLiveData.observe(this) {
            binding.loginButton.isEnabled = it
        }
    }

    private fun initListeners(binding: ActivityLoginBinding) = binding.run {
        loginButton.setOnClickListener {
            viewModel.login()
        }
        userNameEditText.doAfterTextChanged {
            viewModel.onUsernameChanged(it.toString())
        }
    }
}