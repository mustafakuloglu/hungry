package com.kuloglu.hungry.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.kuloglu.hungry.R
import com.kuloglu.hungry.core.BaseActivity
import com.kuloglu.hungry.core.Constants
import com.kuloglu.hungry.databinding.ActivityMainBinding
import com.kuloglu.hungry.ui.detail.DetailActivity

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(MainActivityViewModel::class.java) {
    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes() = R.layout.activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.userList.apply {
            adapter = UserListAdapter { id: Long, view: View ->
                openDetailActivity(id, view)
            }
            viewModel.getUsers().observe(this@MainActivity, Observer {
                viewModel.setUserList(it)
            })
            addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
        }
    }

    private fun openDetailActivity(id: Long, view: View) {
        val detailActivityStarterIntent = Intent(this,DetailActivity::class.java)
        detailActivityStarterIntent.putExtra(Constants.USER_ID,id)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,view,getString(R.string.profile_transition_name))
        startActivity(detailActivityStarterIntent,options.toBundle())
    }
}
