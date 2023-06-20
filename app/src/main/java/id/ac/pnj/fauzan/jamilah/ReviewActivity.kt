package id.ac.pnj.fauzan.jamilah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.pnj.fauzan.jamilah.databinding.ActivityReviewBinding

class ReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}