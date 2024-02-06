package com.example.quicxquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.quicxquiz.databinding.ActivityQuizBinding
import com.example.quicxquiz.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.score)

        binding.score.setText("Congrats!! Your Score is ${intent.getIntExtra("SCORE",0)}")

    }
}