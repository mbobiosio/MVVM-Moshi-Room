package com.mbobiosio.dbpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbobiosio.dbpractice.model.Follower
import com.mbobiosio.dbpractice.model.Results
import com.mbobiosio.dbpractice.repo.UserRepository
import kotlinx.coroutines.launch

/*
* Created by Mbuodile Obiosio on Apr 18, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()

    private val _users = MutableLiveData<List<Follower>?>()
    val users: LiveData<List<Follower>?> get() = _users

    fun getFollowers(userId: Int?) {
        viewModelScope.launch {
            when(val result = followers(userId)) {
                is Results.Success -> _users.postValue(result.value)
                else -> Results.Error()
            }
        }
    }

    private suspend fun followers(userId: Int?) = userRepository.getFollowers(userId)
}