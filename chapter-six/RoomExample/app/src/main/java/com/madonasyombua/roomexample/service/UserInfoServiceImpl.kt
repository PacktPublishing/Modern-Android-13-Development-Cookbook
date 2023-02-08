package com.madonasyombua.roomexample.service

import com.madonasyombua.roomexample.data.UserInfo
import com.madonasyombua.roomexample.data.UserInformationModel
import com.madonasyombua.roomexample.data.dao.UserInformationDao
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@OptIn(FlowPreview::class)
class UserInfoServiceImpl @Inject constructor(
    private val userInformationDao: UserInformationDao
) : UserInfoService {

    override fun getUserInformationFromDB() =
        userInformationDao.getUsersInformation().filter { information ->
            information.isNotEmpty()
        }.flatMapConcat {
            userInformationDao.loadAllUserInformation()
                .map { userInfo ->
                    UserInfo(
                        id = userInfo.id,
                        firstName = userInfo.firstName,
                        lastName = userInfo.lastName,
                        dateOfBirth = userInfo.dateOfBirth,
                        gender = userInfo.gender,
                        city = userInfo.city,
                        profession = userInfo.profession
                    )
                }
        }

    override suspend fun addUserInformationInDB(userInformation: UserInfo) {
        userInformationDao.insertUserInformation(
            UserInformationModel(
                firstName = userInformation.firstName,
                lastName = userInformation.lastName,
                dateOfBirth = userInformation.dateOfBirth,
                gender = userInformation.gender,
                city = userInformation.city,
                profession = userInformation.profession
            )
        )
    }
}