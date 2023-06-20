package id.ac.pnj.fauzan.jamilah.authentication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import id.ac.pnj.fauzan.jamilah.MainActivity
import id.ac.pnj.fauzan.jamilah.R
import id.ac.pnj.fauzan.jamilah.Result
import id.ac.pnj.fauzan.jamilah.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("session")
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this, RegisterViewModelFactory.getInstance(dataStore))[RegisterViewModel::class.java]

        binding.btnRegister.setOnClickListener {
            viewModel.register(binding.edtRegisterNama.editText?.text.toString(),
                binding.edtRegisterNohp.editText?.text.toString(),
                binding.edtRegisterEmail.editText?.text.toString(),
                binding.edtRegisterPassword.editText?.text.toString()).observe(this) { result ->
                if (result != null) {
                    when (result) {
                        is Result.Success -> startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                        is Result.Error -> {
                            Toast.makeText(this, result.error, Toast.LENGTH_SHORT).show()
                            binding.btnRegister.isEnabled = true
                        }
                        is Result.Loading -> {
                            binding.btnRegister.isEnabled = false
                        }
                    }
                }
            }

        }
    }
}