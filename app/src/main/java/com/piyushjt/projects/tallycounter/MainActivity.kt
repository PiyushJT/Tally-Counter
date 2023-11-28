package com.piyushjt.projects.tallycounter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import com.piyushjt.projects.tallycounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val noText= binding.count

        binding.addCount.setOnClickListener {
            noText.text= count()
            vibe()
        }

        binding.reset.setOnClickListener {
            reset()
            vibe()
        }

    }

    fun count(): String{
        val noText= binding.count.text.toString().toInt()
        return "${noText+1}"
    }

    fun reset(){
        val noText= binding.count
        noText.text = "0"
    }

    fun vibe(){
        val vibrate= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrate.vibrate(VibrationEffect.createOneShot(55, VibrationEffect.DEFAULT_AMPLITUDE))
    }

    fun vibeLong(){
        val vibrate= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrate.vibrate(VibrationEffect.createOneShot(75, VibrationEffect.DEFAULT_AMPLITUDE))
    }

}