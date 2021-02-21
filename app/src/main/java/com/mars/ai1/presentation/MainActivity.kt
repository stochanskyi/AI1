package com.mars.ai1.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.mars.ai1.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        fun start(context: Context) {
            context.startActivity(
                Intent(context, MainActivity::class.java).apply {
                    flags += Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
            )
        }
    }
}