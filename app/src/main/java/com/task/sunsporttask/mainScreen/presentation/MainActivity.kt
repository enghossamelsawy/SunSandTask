package com.task.sunsporttask.mainScreen.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.task.sunsporttask.R
import com.task.sunsporttask.base.ext.showSnakeBar
import com.task.sunsporttask.detailsscreen.UserDetailsActivity
import com.task.sunsporttask.mainScreen.data.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.loading_white.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private val viewModel: MainViewModel by viewModel()
    private val linearLayoutManager by lazy { LinearLayoutManager(this) }
    private val userList = mutableListOf<User>()
    private val userAdapter: UserAdapter by lazy {
        UserAdapter(userList, ::onUerClicked)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.searchResultLiveData.observe(this, Observer { updateUi(it) })
        viewModel.searchResultLoadingLiveData.observe(this, Observer { updateLoading(it) })
        recycleViewUserList.layoutManager = linearLayoutManager
        recycleViewUserList.adapter = userAdapter
        addLoadMoreListener()
        viewModel.getUser()
    }

    private fun updateLoading(viewLoadingState: ViewLoadingState) {
        when (viewLoadingState) {
            ViewLoadingState.ShowLoading -> showLoading()
            ViewLoadingState.HideLoading -> hideLoading()
            ViewLoadingState.ShowLoadMoreLoading -> showLoadMoreLoading()
            ViewLoadingState.HideLoadMoreLoading -> hideLoadMoreLoading()
        }
    }

    private fun updateUi(mainStatus: MainStatus?) {
        when (mainStatus) {
            MainStatus.DataError -> showError(mainStatus.data as String)

            MainStatus.ShowNoResults -> {
                tvNoItems.visibility = View.VISIBLE
                recycleViewUserList.visibility = View.GONE
            }
            MainStatus.ShowUserListView -> {
                if (mainStatus.data is List<*>) {
                    val users = mainStatus.data as List<User>
                    if (users.isEmpty()) {
                        removeLoadMoreListener()
                    } else {
                        userList.addAll(users)
                        userAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    private fun onUerClicked(user: User) {
        UserDetailsActivity.launch(this, user)
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

    private fun showLoadMoreLoading() {
        progressLoadMore.visibility = View.VISIBLE
    }

    private fun hideLoadMoreLoading() {
        progressLoadMore.visibility = View.GONE
    }


    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount: Int = linearLayoutManager.childCount
            val totalItemCount: Int = linearLayoutManager.itemCount
            val firstVisibleItemPosition: Int = linearLayoutManager.findFirstVisibleItemPosition()
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                viewModel.getUser()
            }
        }


    }


    private fun addLoadMoreListener() {
        recycleViewUserList.addOnScrollListener(recyclerViewOnScrollListener)
    }

    private fun removeLoadMoreListener() {
        recycleViewUserList.removeOnScrollListener(recyclerViewOnScrollListener)
    }


}
