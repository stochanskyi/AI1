package com.mars.ai1.presentation.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mars.ai1.R
import com.mars.ai1.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentLoginBinding.bind(view).run {
            initViews(this)
            initListeners(this)
        }
    }

    private fun initViews(binding: FragmentLoginBinding) {

    }

    private fun initListeners(binding: FragmentLoginBinding) = binding.run {
        loginButton.setOnClickListener {
            Navigation.findNavController(view ?: return@setOnClickListener)
                .navigate(R.id.action_to_questions)
        }
    }
}