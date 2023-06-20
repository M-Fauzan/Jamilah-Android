package id.ac.pnj.fauzan.jamilah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.pnj.fauzan.jamilah.databinding.ActivityConfirmBinding

class ConfirmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirmOrder.setOnClickListener {
            startActivity(Intent(this, TrackActivity::class.java))
        }
    }
}