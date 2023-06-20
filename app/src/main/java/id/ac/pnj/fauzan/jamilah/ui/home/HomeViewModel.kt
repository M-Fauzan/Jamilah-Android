package id.ac.pnj.fauzan.jamilah.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import id.ac.pnj.fauzan.jamilah.authentication.Session
import id.ac.pnj.fauzan.jamilah.authentication.SessionRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val sessionRepository: SessionRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getSession(): LiveData<Session> = sessionRepository.getSession().asLiveData()

    fun logout() {
        viewModelScope.launch {
            sessionRepository.logout()
        }
    }
}