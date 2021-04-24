package com.mbobiosio.dbpractice.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mbobiosio.dbpractice.databinding.ActivityUsersBinding
import com.mbobiosio.dbpractice.listener.UserListener
import com.mbobiosio.dbpractice.model.User
import com.mbobiosio.dbpractice.ui.adapter.UserAdapter
import com.mbobiosio.dbpractice.viewmodel.UserViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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

        initRecyclerView()

        GlobalScope.launch {
            viewModel.users.collectLatest {
                adapter.submitData(it)
            }
        }

    }
    private fun initRecyclerView() {
        adapter = UserAdapter(object : UserListener {
            override fun onItemClicked(user: User) {
                Timber.d("${user.followerData?.fullName}")
            }
        })
        binding.users.adapter = adapter
    }
}