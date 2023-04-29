package com.madonasyombua.roomexample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madonasyombua.roomexample.data.UserInfo
import com.madonasyombua.roomexample.service.UserInfoService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val userInfoService: UserInfoService
) : ViewModel() {

    fun saveUserInformationData(userInfo: UserInfo) {
        viewModelScope.launch {
            Log.d("Task", "asdf Data was inserted correctly")
            userInfoService.addUserInformationInDB(userInfo)
        }
    }
}