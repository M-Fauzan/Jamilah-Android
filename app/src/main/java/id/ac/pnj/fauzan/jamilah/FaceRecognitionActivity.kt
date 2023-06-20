package id.ac.pnj.fauzan.jamilah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import id.ac.pnj.fauzan.jamilah.databinding.ActivityFaceRecognitionBinding

class FaceRecognitionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFaceRecognitionBinding
    companion object {
        private val CAMERA_X_RESULT = 200
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnFacerecognition.setOnClickListener {

        }
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {

        }
    }
}