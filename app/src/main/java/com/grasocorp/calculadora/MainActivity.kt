package com.grasocorp.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grasocorp.calculadora.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bot0.setOnClickListener{
            agregarPantalla("0")
        }
        binding.bot1.setOnClickListener{
            agregarPantalla("1")
        }
        binding.bot2.setOnClickListener{
            agregarPantalla("2")
        }
        binding.bot3.setOnClickListener{
            agregarPantalla("3")
        }
        binding.bot4.setOnClickListener{
            agregarPantalla("4")
        }
        binding.bot5.setOnClickListener{
            agregarPantalla("5")
        }
        binding.bot6.setOnClickListener{
            agregarPantalla("6")
        }
        binding.bot7.setOnClickListener{
            agregarPantalla("7")
        }
        binding.bot8.setOnClickListener{
            agregarPantalla("8")
        }
        binding.bot9.setOnClickListener{
            agregarPantalla("9")
        }
        binding.botCambio.setOnClickListener{
            cambiarSigno()
        }
        binding.botBorrarTodo.setOnClickListener{
            binding.tvPantalla.text=""
            binding.tvPantalla2.text = ""
        }
        binding.botX.setOnClickListener{
            eliminarUnoaUno()
        }
        binding.botPunto.setOnClickListener{
            agregarPunto()
        }
        binding.botSuma.setOnClickListener{
            sumar()
        }
        binding.botResta.setOnClickListener{
            resta()
        }
        binding.botMulti.setOnClickListener{
            multiplicar()
        }

        binding.botDivi.setOnClickListener{
            division()
        }


        binding.botIgual.setOnClickListener{
            resultado()
            }


    }

    fun agregarPantalla(num: String){
        var texto = binding.tvPantalla.text
        if( texto.length <= 8){
            if(texto == "" && num == "0") {
                texto = ""
            }else{
                texto = texto.toString() + num
                binding.tvPantalla.text = texto
            }
        }
    }

    fun cambiarSigno(){
        var texto = binding.tvPantalla.text
        if (texto != ""){
            val signo = texto.get(0).toString()
            if(signo != "-"){
                texto = "-" + texto
                binding.tvPantalla.text = texto
            }else{
                texto = texto.substring(1)
                binding.tvPantalla.text = texto
            }
        }
        }

    fun eliminarUnoaUno(){
        val texto = binding.tvPantalla.text
        var signo= ""
        if(texto.length > 0){
            signo = texto.get(0).toString()
        }
        if(texto.length == 2 && signo == "-" ){
            binding.tvPantalla.text = ""
        }else if(texto.length > 0){
            val elim = texto?.replaceFirst(".$".toRegex(), "")
            binding.tvPantalla.text = elim
        }
    }

    fun agregarPunto(){
        var texto = binding.tvPantalla.text
        if(texto == ""){
            binding.tvPantalla.text = "0."
        }else{
            texto = texto.toString() + "."
            binding.tvPantalla.text = texto
        }
    }

    fun sumar(){
        if(binding.tvPantalla.text != "") {
                var texto = binding.tvPantalla.text
                texto = texto.toString() + "+"
                binding.tvPantalla2.text = texto
                binding.tvPantalla.text = ""
            }


    }

    fun resta(){
        if(binding.tvPantalla.text != "") {
            var texto = binding.tvPantalla.text
            texto = texto.toString() + "-"
            binding.tvPantalla2.text = texto
            binding.tvPantalla.text = ""
            }

    }

    fun multiplicar(){
        if(binding.tvPantalla.text != "") {
            var texto = binding.tvPantalla.text
            texto = texto.toString() + "*"
            binding.tvPantalla2.text = texto
            binding.tvPantalla.text = ""
            }

    }

    fun division(){
        if(binding.tvPantalla.text != "") {
            var texto = binding.tvPantalla.text
            texto = texto.toString() + "/"
            binding.tvPantalla2.text = texto
            binding.tvPantalla.text = ""
            }

    }

    fun resultado(){
        if(binding.tvPantalla.text == "" && binding.tvPantalla2.text == ""){
            binding.tvPantalla.text = ""
        }else if(binding.tvPantalla.text != "" && binding.tvPantalla2.text == "" ){
            binding.tvPantalla.text = binding.tvPantalla.text
        }else{
            val texto1 = binding.tvPantalla2.text
            val signo = texto1.substring(texto1.length-1, texto1.length)
            println(signo)
            println("Lo de arriba es el signo en teoria")
            val texto2 = binding.tvPantalla.text
            val num1 = (texto1.substring(0,(texto1.length-1))).toFloat()
            val num2 = texto2.toString().toFloat()
            var operacion = num1 + num2

            if(signo == "+"){
                operacion = num1 + num2
            }else if(signo == "-"){
                operacion = num1 - num2
            }else if(signo == "*"){
                operacion = num1 * num2
            }else if(signo == "/"){
                operacion = num1 / num2
            }
            var resultado = operacion.toString()
            if(resultado.length == 2){
                resultado = Math.round(resultado.toDouble()).toString()
                binding.tvPantalla.text = resultado
                binding.tvPantalla2.text = ""
            }else{
                var resultadoRedon = resultado.toFloat()
                resultadoRedon = (resultadoRedon * 100.0).roundToInt().toFloat() / 100
                binding.tvPantalla.text = resultadoRedon.toString()
                binding.tvPantalla2.text = ""
            }
        }

        }


    }





