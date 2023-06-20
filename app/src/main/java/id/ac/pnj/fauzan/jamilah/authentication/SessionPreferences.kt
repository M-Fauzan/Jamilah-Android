package id.ac.pnj.fauzan.jamilah.authentication

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SessionPreferences private constructor(val dataStore: DataStore<Preferences>) {
    fun getSession(): Flow<Session> {
        return dataStore.data.map {
            Session(
                it[USER_ID_KEY] ?: -1,
                it[NAME_KEY] ?: "",
                it[TOKEN_KEY] ?: "",
            )
        }
    }

    suspend fun login(session: Session) {
        dataStore.edit {
            it[USER_ID_KEY] = session.id
        }
    }

    suspend fun logout() {
        dataStore.edit {
            it[USER_ID_KEY] = -1
            it[NAME_KEY] = ""
            it[TOKEN_KEY] = ""
        }
    }
    companion object {
        @Volatile
        private var INSTANCE: SessionPreferences? = null

        private var USER_ID_KEY = intPreferencesKey("id")
        private var NAME_KEY = stringPreferencesKey("name")

        private var TOKEN_KEY = stringPreferencesKey("token")

        fun getInstance(dataStore: DataStore<Preferences>): SessionPreferences {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: SessionPreferences(dataStore).also {
                    INSTANCE = it
                }
            }
        }
    }
}