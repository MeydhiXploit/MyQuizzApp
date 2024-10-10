package com.medev.quizzprogrammerapp.ui.prepare

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.medev.quizzprogrammerapp.R
import com.medev.quizzprogrammerapp.databinding.ActivityPrepareBinding
import com.medev.quizzprogrammerapp.ui.content.ContentActivity

class PrepareActivity : AppCompatActivity() {

    private lateinit var prepareBinding: ActivityPrepareBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareBinding = ActivityPrepareBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(prepareBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        onClick()
    }

    private fun onClick() {
        prepareBinding.btnStart.setOnClickListener{
            val nickname = prepareBinding.etNickname.text.toString()
            if (checkValidation(nickname)) {
                val intent = Intent(this, ContentActivity::class.java)
                intent.putExtra(ContentActivity.EXTRA_NICKNAME, nickname)
                startActivity(intent)
            }
        }
    }

    private fun checkValidation(nickname: String): Boolean {
        return if(nickname.isEmpty()){
            prepareBinding.etNickname.error = getString(R.string.plase_field_your_nickname)
            false
        }else{
            true
        }
    }
}