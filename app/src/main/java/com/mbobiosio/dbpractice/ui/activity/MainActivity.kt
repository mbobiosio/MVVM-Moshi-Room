package com.mbobiosio.dbpractice.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mbobiosio.dbpractice.viewmodel.PostsViewModel
import com.mbobiosio.dbpractice.databinding.ActivityMainBinding
import com.mbobiosio.dbpractice.listener.PostListener
import com.mbobiosio.dbpractice.model.Post
import com.mbobiosio.dbpractice.ui.adapter.PostAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<PostsViewModel>()
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        initRecyclerView()

        Timber.d("Main")

        lifecycleScope.launch {
            viewModel.feed.collectLatest {
                adapter.submitData(it)
            }
        }

        binding.users.setOnClickListener {
            Intent(this, UsersActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun initRecyclerView() {
        adapter = PostAdapter(object : PostListener {
            override fun onItemClicked(post: Post) {
                Timber.d("${post.details}")
            }
        })
        binding.posts.adapter = adapter
    }
}