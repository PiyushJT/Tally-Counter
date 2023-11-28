package com.piyushjt.projects.tallycounter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.appcompat.app.AlertDialog
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
            vibeLong()
        }

    }

    fun count(): String{
        val noText= binding.count.text.toString().toInt()
        return "${noText+1}"
    }

    fun reset(){
        val alertBox= AlertDialog.Builder(this)
        alertBox.setTitle("Confirm reset?")
        alertBox.setMessage("This will reset your counting")
        alertBox.setPositiveButton("Yes") { _,_ ->
            val noText= binding.count
            noText.text = "0"
        }
        alertBox.setNegativeButton("No"){dialog, _ ->
            dialog.cancel()
        }
        alertBox.create().show()

    }

    fun vibe(){
        val vibrate= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrate.vibrate(VibrationEffect.createOneShot(55, VibrationEffect.DEFAULT_AMPLITUDE))
    }

    fun vibeLong(){
        val vibrate= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrate.vibrate(VibrationEffect.createOneShot(95, VibrationEffect.DEFAULT_AMPLITUDE))
    }

}