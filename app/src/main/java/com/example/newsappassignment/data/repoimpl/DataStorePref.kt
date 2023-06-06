package com.example.newsappassignment.data.repoimpl

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsappassignment.app.di.qualifiers.IODispatcher
import com.example.newsappassignment.app.utils.PERF_NAME
import com.example.newsappassignment.domain.repo.IDataStorePref
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

val Context.dataStore by preferencesDataStore(name = PERF_NAME)

class DataStorePref @Inject constructor(
    private val context: Context,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : IDataStorePref {
    override suspend fun setSkipOnboard(key: String, value: Boolean) {
        withContext(ioDispatcher) {
            val prefKey = booleanPreferencesKey(key)
            context.dataStore.edit { preferences ->
                preferences[prefKey] = value
            }
        }
    }

    override suspend fun getSkipOnboard(key: String): Boolean? {
        return withContext(ioDispatcher) {
            try {
                val prefKey = booleanPreferencesKey(key)
                val preferences = context.dataStore.data.first()
                preferences[prefKey]
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}