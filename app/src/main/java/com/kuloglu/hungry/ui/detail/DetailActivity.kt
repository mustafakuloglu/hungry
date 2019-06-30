package com.kuloglu.hungry.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.Observable
import com.kuloglu.hungry.R
import com.kuloglu.hungry.core.BaseActivity
import com.kuloglu.hungry.core.Constants
import com.kuloglu.hungry.databinding.ActivityDetailBinding
import com.kuloglu.hungry.utils.extensions.toast

class DetailActivity : BaseActivity<DetailActivityViewModel, ActivityDetailBinding>(DetailActivityViewModel::class.java) {

    var saveItem : MenuItem? = null

    override fun initViewModel(viewModel: DetailActivityViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes() = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setUser(intent.getLongExtra(Constants.USER_ID,0L))
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        viewModel.saveVisibility.addOnPropertyChangedCallback(object :  Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                viewModel.saveVisibility.get()?.let {isVisible -> saveItem?.let {  it.isVisible = isVisible }}
            }
        })

        viewModel.errorToastCallBack =  {
            toast( getString(R.string.save_error_toast))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            menuInflater.inflate(R.menu.menu_items,it)
            saveItem = it.findItem(R.id.save)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            when(item.itemId)
            {
                R.id.save -> viewModel.saveClick()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
