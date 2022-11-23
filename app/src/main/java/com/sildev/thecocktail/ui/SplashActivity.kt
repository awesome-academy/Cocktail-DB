package com.sildev.thecocktail.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sildev.thecocktail.utils.Constant
import java.util.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }

        }, Constant.TIME_DELAY_SPLASH)
    }
}
