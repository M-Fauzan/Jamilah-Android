package id.ac.pnj.fauzan.jamilah.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.pnj.fauzan.jamilah.ConfirmActivity
import id.ac.pnj.fauzan.jamilah.databinding.ActivityFacialBinding

class FacialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFacialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFacialOrder.setOnClickListener {
            startActivity(Intent(this, ConfirmActivity::class.java))
        }
    }
}