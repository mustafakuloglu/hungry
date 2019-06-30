package com.kuloglu.hungry.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.databinding.Observable
import com.kuloglu.hungry.R
import com.kuloglu.hungry.core.BaseActivity
import com.kuloglu.hungry.databinding.ActivityLoginBinding
import com.kuloglu.hungry.ui.main.MainActivity
import com.kuloglu.hungry.utils.extensions.toast

class LoginActivity : BaseActivity<LoginActivityViewModel, ActivityLoginBinding>(LoginActivityViewModel::class.java) {
    override fun getLayoutRes() = R.layout.activity_login

    override fun initViewModel(viewModel: LoginActivityViewModel) {
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.errorToastCallBack =  {
            toast( getString(R.string.login_error_message))
        }
        viewModel.enterActivity.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                finish()
            }
        })
    }

}
