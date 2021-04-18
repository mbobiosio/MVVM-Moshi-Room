package com.mbobiosio.dbpractice.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mbobiosio.dbpractice.R
import com.mbobiosio.dbpractice.databinding.ActivityUsersBinding
import com.mbobiosio.dbpractice.listener.UserListener
import com.mbobiosio.dbpractice.model.Follower
import com.mbobiosio.dbpractice.ui.adapter.UserAdapter
import com.mbobiosio.dbpractice.viewmodel.UserViewModel
import timber.log.Timber

class UsersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsersBinding
    private val viewModel by viewModels<UserViewModel>()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        viewModel.getFollowers(1)

        initRecyclerView()

        viewModel.users.observe(this) {
            adapter.submitList(it)
        }
    }
    private fun initRecyclerView() {
        adapter = UserAdapter(object : UserListener {
            override fun onItemClicked(user: Follower) {
                Timber.d("${user.followerData?.fullName}")
            }
        })
        binding.users.adapter = adapter
    }
}