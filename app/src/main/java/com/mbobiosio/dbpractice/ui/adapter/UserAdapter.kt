package com.mbobiosio.dbpractice.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mbobiosio.dbpractice.databinding.ItemUserBinding
import com.mbobiosio.dbpractice.listener.UserListener
import com.mbobiosio.dbpractice.model.Follower

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class UserAdapter(
    var listener: UserListener
) : ListAdapter<Follower, UserAdapter.UserViewHolder>(ItemCallback()) {

    private class ItemCallback : DiffUtil.ItemCallback<Follower>() {
        override fun areItemsTheSame(oldItem: Follower, newItem: Follower): Boolean {
            return oldItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Follower, newItem: Follower): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, listener)
        }
    }

    class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: Follower,
                 listener: UserListener
        ) {
            binding.user = user
            binding.clickListener = listener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): UserViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
                return UserViewHolder(binding)
            }
        }
    }
}