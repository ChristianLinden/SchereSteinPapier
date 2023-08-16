package com.example.scheresteinpapier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.scheresteinpapier.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSpielStarten.setOnClickListener {
            val spieler1Eingabe = binding.editPl1.text.toString()
            val spieler2Eingabe = binding.editPl2.text.toString()

            if (spieler1Eingabe.isNotEmpty() && spieler2Eingabe.isNotEmpty()) {
                spielAuswerten(spieler1Eingabe, spieler2Eingabe)
            } else {
                binding.tvErgebnis.text = "Fehler bei der Eingabe!"
            }
        }
    }

    fun spielAuswerten(spieler1: String, spieler2: String) {
        val gültigeEingaben = listOf("Stein", "Schere", "Papier")

        if (spieler1 !in gültigeEingaben || spieler2 !in gültigeEingaben) {
            binding.tvErgebnis.text = "Falsche Eingabe! Bitte gib Stein, Schere oder Papier ein."
            return
        }

        if (spieler1 == spieler2) {
            binding.tvErgebnis.text = "Unentschieden!"
        } else if (
            (spieler1 == "Stein" && spieler2 == "Schere") ||
            (spieler1 == "Schere" && spieler2 == "Papier") ||
            (spieler1 == "Papier" && spieler2 == "Stein")
        ) {
            binding.tvErgebnis.text = "Spieler 1 gewinnt!"
        } else {
            binding.tvErgebnis.text = "Spieler 2 gewinnt!"
        }
    }
}