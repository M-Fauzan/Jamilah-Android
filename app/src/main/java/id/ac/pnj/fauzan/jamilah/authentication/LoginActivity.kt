package id.ac.pnj.fauzan.jamilah.authentication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import id.ac.pnj.fauzan.jamilah.MainActivity
import id.ac.pnj.fauzan.jamilah.Result
import id.ac.pnj.fauzan.jamilah.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("session")
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this, LoginViewModelFactory.getInstance(dataStore))[LoginViewModel::class.java]

        binding.btnLogin.setOnClickListener {
            viewModel.login(
                binding.edtLoginEmail.editText?.text.toString(),
                binding.edtLoginPassword.editText?.text.toString()).observe(this) { result ->
                    if (result != null) {
                        when (result) {
                            is Result.Success -> startActivity(Intent(
                                this@LoginActivity, RegisterActivity::class.java))
                            is Result.Error -> {

                                Toast.makeText(
                                    this, result.error, Toast.LENGTH_SHORT
                                ).show()
                                binding.btnLogin.isEnabled = true
                            }
                            is Result.Loading -> {
                                binding.btnLogin.isEnabled = false
                            }
                        }
                    }
            }
        }
        val string = SpannableString("Belum punya akun? Daftar sekarang")
        string.setSpan(object: ClickableSpan() {
            override fun onClick(p0: View) {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
        }, 18, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvLoginRegister.text = string
        binding.tvLoginRegister.movementMethod = LinkMovementMethod.getInstance()
    }
}