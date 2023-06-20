package id.ac.pnj.fauzan.jamilah.ui.home

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.pnj.fauzan.jamilah.Injection
import id.ac.pnj.fauzan.jamilah.authentication.LoginViewModelFactory
import id.ac.pnj.fauzan.jamilah.authentication.SessionRepository

class HomeViewModelFactory(private val sessionRepository: SessionRepository):
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(sessionRepository) as T
        }
        throw IllegalArgumentException()

    }

    companion object {
        @Volatile
        private var INSTANCE: HomeViewModelFactory? = null
        fun getInstance(dataStore: DataStore<Preferences>): HomeViewModelFactory {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: HomeViewModelFactory(Injection.provideSessionRepository(dataStore))
            }
        }
    }
}