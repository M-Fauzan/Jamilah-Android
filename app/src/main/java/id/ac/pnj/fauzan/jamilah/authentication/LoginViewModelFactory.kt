package id.ac.pnj.fauzan.jamilah.authentication

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.pnj.fauzan.jamilah.Injection

class LoginViewModelFactory(private val sessionRepository: SessionRepository):
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(sessionRepository) as T
        }
        throw IllegalArgumentException()

    }

    companion object {
        @Volatile
        private var INSTANCE: LoginViewModelFactory? = null
        fun getInstance(dataStore: DataStore<Preferences>): LoginViewModelFactory {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: LoginViewModelFactory(Injection.provideSessionRepository(dataStore))
            }
        }
    }
}