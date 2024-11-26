package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
const val key_result_imc  = "ResulActivity.key_imc"
class ResulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resul)

        val result = intent.getFloatExtra(key_result_imc, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_resultado)
        val tvClasificacion = findViewById<TextView>(R.id.tv_clasificion)
        tvResult.text = result.toString()

            val clasificacion: String = if (result <= 18.5f){
            "Magreza"
        } else if (result > 18.5f && result <= 24.9f){
            "Normal"
        } else if (result > 25f && result <= 29.9f){
            "Sobre peso"

        } else if (result > 30f && result <= 39.9f){
            "Obesidade"
        }else {
            "Obesidade Grave"
        }
        tvClasificacion.text = clasificacion
        
         val color = when (clasificacion) {
            "Magreza", "Obesidade", "Obesidade Grave" -> android.graphics.Color.RED
            "Normal" -> android.graphics.Color.GREEN
            "Sobre peso" -> android.graphics.Color.YELLOW
            else -> android.graphics.Color.BLACK
        }
        tvClasificacion.setTextColor(color)
    }
}
