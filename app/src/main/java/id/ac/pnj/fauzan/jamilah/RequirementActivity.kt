package id.ac.pnj.fauzan.jamilah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import id.ac.pnj.fauzan.jamilah.databinding.ActivityRequirementBinding

class RequirementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRequirementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requirement)

        binding.btnRequirement.setOnClickListener {
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }
    }
}