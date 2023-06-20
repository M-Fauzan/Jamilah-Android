package id.ac.pnj.fauzan.jamilah

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import id.ac.pnj.fauzan.jamilah.authentication.SessionPreferences
import id.ac.pnj.fauzan.jamilah.authentication.SessionRepository
import id.ac.pnj.fauzan.jamilah.retrofit.ApiConfig

object Injection {
    private val apiService = ApiConfig.getApiService()
    fun provideSessionRepository(dataStore: DataStore<Preferences>): SessionRepository {
        val sessionPreferences = SessionPreferences.getInstance(dataStore)
        return SessionRepository(apiService, sessionPreferences)
    }
}