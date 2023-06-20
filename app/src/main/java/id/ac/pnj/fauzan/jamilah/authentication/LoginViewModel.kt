package id.ac.pnj.fauzan.jamilah.authentication

import androidx.lifecycle.ViewModel

class LoginViewModel(
    private val sessionRepository: SessionRepository
): ViewModel() {
    fun login(email: String, password: String) = sessionRepository.login(email, password)
}