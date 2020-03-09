package com.task.sunsporttask.mainScreen.prenstation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.sunsporttask.R
import com.task.sunsporttask.base.ext.showSnakeBar
import com.task.sunsporttask.mainScreen.data.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.loading_white.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by viewModel()
    private val linearLayoutManager by lazy { LinearLayoutManager(this) }
    private val userAdapter: UserAdapter by lazy {
        UserAdapter(emptyList(), ::onUerClicked)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.searchResultLiveData.observe(this, Observer { updateUi(it) })
        viewModel.getUser()
    }

    private fun updateUi(mainStatus: MainStatus?) {

        when (mainStatus) {
            MainStatus.ShowLoading -> showLoading()
            MainStatus.DataError -> {
                hideLoading()
                showError(mainStatus.data as String)
            }
            MainStatus.ShowUserListView -> {
                if (mainStatus.data is List<*>)
                    userAdapter.setList(mainStatus.data as List<User>)
                recycleViewUserList.layoutManager = linearLayoutManager
                recycleViewUserList.adapter = userAdapter

            }
        }


    }

    private fun onUerClicked(user: User) {

    }

    private fun hideLoading() {
        transparentLoadingView.visibility = View.GONE
    }

    private fun showError(error: String) {
        rootView.showSnakeBar(error)
    }

    private fun showLoading() {
        transparentLoadingView.visibility = View.VISIBLE
    }
}
