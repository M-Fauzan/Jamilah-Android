package id.ac.pnj.fauzan.jamilah.authentication

import androidx.lifecycle.ViewModel

class RegisterViewModel(
    private val sessionRepository: SessionRepository
): ViewModel() {
    fun register(name: String, handphoneNumber: String, email: String, password: String) =
        sessionRepository.register(name, handphoneNumber, email, password)
}