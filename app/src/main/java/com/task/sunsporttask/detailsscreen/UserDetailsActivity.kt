package com.task.sunsporttask.detailsscreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.task.sunsporttask.R
import com.task.sunsporttask.base.ext.loadImageWithCaredEdgeFormResources
import com.task.sunsporttask.mainScreen.data.User
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        if (intent.hasExtra(USER_DETAILS)) {
            updateUser(intent.getParcelableExtra(USER_DETAILS))
        }
    }

    private fun updateUser(user: User?) {
        user?.let {

            imgUser.loadImageWithCaredEdgeFormResources(user.picture?.large)
            tvGender.text = user.gender
            tvUserFullName.text =
                "${user.name?.title ?: ""} ${user.name?.first ?: ""} ${user.name?.last ?: ""}"
            tvEmail.text = user.email
            tvAddress.text =
                "${user.location?.country ?: ""} , ${user.location?.city ?: ""} , ${user.location?.state ?: ""}"
        }
    }


    companion object {
        const val USER_DETAILS = "user_details"

        @JvmStatic
        fun launch(context: Activity, user: User) {
            val intent = Intent(context, UserDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable(USER_DETAILS, user)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

    }

}
