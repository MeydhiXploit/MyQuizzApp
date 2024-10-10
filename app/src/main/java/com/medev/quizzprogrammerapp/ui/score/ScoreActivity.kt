package com.medev.quizzprogrammerapp.ui.score

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.medev.quizzprogrammerapp.R
import com.medev.quizzprogrammerapp.databinding.ActivityScoreBinding
import com.medev.quizzprogrammerapp.ui.main.MainActivity
import com.medev.quizzprogrammerapp.ui.prepare.PrepareActivity

class ScoreActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_SCORE = "extra_score"
        const val EXTRA_NICKNAME = "extra_nickname"
    }

    private lateinit var scoreBinding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scoreBinding = ActivityScoreBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(scoreBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Get data
        if(intent != null){
            val score = intent.getIntExtra(EXTRA_SCORE, 0)
            val nickname = intent.getStringExtra(EXTRA_NICKNAME)
            scoreBinding.tvNickname.text = nickname
            scoreBinding.tvScore.text = score.toString()
        }
        onClick()
    }

    private fun onClick() {
        scoreBinding.btnDone.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            // destroy setelah masuk ke mainactivity biar tidak numpuk
            finishAffinity()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
        finishAffinity()
    }
}