package id.ac.pnj.fauzan.jamilah.authentication

import androidx.lifecycle.*
import id.ac.pnj.fauzan.jamilah.Result
import id.ac.pnj.fauzan.jamilah.retrofit.ApiService
import kotlinx.coroutines.flow.Flow

class SessionRepository(
    private val apiService: ApiService,
    private val sessionPreferences: SessionPreferences
) {
    fun login(email: String, password: String) = liveData {
        emit(Result.Loading)

        try {
            val client = apiService.login(email, password)


            sessionPreferences.login(Session(client.id ?: -1))
            val result: LiveData<Result<Session>> = sessionPreferences.getSession().asLiveData().map {
                Result.Success(it)
            }
            emitSource(result)
        } catch (e: Exception) {
            emit(Result.Error("Exception occured at login function: ${e.message.toString()}"))
        }

    }

    fun getSession(): Flow<Session> {
        return sessionPreferences.getSession()
    }

    suspend fun logout() {
        sessionPreferences.logout()
    }

    fun register(name: String, handphoneNumber: String, email: String, password: String) = liveData {
        emit(Result.Loading)
        try {
            apiService.register(name, handphoneNumber, email, password)
            val result: LiveData<Result<Boolean>> = MutableLiveData(Result.Success(true))
            emitSource(result)
        } catch (e: Exception) {
            emit(Result.Error("Exception occured at register function: ${e.message.toString()}"))
        }
    }

}