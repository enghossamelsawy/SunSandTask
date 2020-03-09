package com.task.sunsporttask.mainScreen.prenstation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task.sunsporttask.R
import com.task.sunsporttask.base.ext.loadImageWithCaredEdgeFormResources
import com.task.sunsporttask.mainScreen.data.User
import kotlinx.android.synthetic.main.item_user_layout.view.*

class UserAdapter(
    private val userList: List<User>,
    private val onUserClicked: (User) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList[holder.adapterPosition]
        (holder as UserViewHolder).apply {
            tvUser.text = "${user.name.first ?: ""} ${user.name.last ?: ""}"
            tvGender.text = user.gender
            imgUser.loadImageWithCaredEdgeFormResources(user.picture.thumbnail)
        }
        holder.itemView.setOnClickListener {
            onUserClicked(user)
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUser: TextView = itemView.tvUserName
        val imgUser: ImageView = itemView.imgUser
        val tvGender: TextView = itemView.tvGender
    }

}