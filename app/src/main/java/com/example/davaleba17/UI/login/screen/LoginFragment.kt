package com.example.davaleba17.UI.login.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.davaleba17.Util.BaseFragment
import com.example.davaleba17.UI.login.vm.LoginViewModel
import com.example.davaleba17.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}