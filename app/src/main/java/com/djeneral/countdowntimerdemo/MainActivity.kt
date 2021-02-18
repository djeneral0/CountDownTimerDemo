package com.djeneral.countdowntimerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.djeneral.countdowntimerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var countDownTimer: CountDownTimer? = null
    private var timerDuration: Long = 60000
    private var pauseOffset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTimer.text = "${(timerDuration/1000)}"

        binding.startBtn.setOnClickListener{
            startTimer(pauseOffset)
        }

        binding.pauseBtn.setOnClickListener {
            pauseTimer()
        }

        binding.restartBtn.setOnClickListener {
            resetTime()
        }

    }

    private fun startTimer(pauseOffsetL: Long){
        countDownTimer = object : CountDownTimer(timerDuration - pauseOffsetL, 1000){
            override fun onTick(millisUntilFinished: Long) {
                pauseOffset = timerDuration - millisUntilFinished
                binding.tvTimer.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                showToast("Timer has Finished")
            }
        }.start()
    }

    private fun pauseTimer(){
        if (countDownTimer != null){
            countDownTimer!!.cancel()
        }
    }

    private fun resetTime(){
        if (countDownTimer != null){
            countDownTimer!!.cancel()
            binding.tvTimer.text = "${(timerDuration/1000)}"

            countDownTimer = null
            pauseOffset = 0
        }
    }
}