package com.example.newsappassignment.data.repoimpl

import com.example.newsappassignment.domain.repo.IDataStorePref
import com.example.newsappassignment.domain.repo.IPrepRepo
import javax.inject.Inject

class PrefRepoImpl @Inject constructor(
    private val pref: IDataStorePref
) : IPrepRepo {
    override suspend fun setSkipOnboard(key: String, value: Boolean) {
        pref.setSkipOnboard(key, value)
    }

    override suspend fun getSkipOnboard(key: String): Boolean? {
        return pref.getSkipOnboard(key)
    }
}