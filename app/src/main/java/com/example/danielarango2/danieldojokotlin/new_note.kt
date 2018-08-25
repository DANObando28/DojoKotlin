package com.example.danielarango2.danieldojokotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.example.danielarango2.danieldojokotlin.DataBase.dbhelper
import com.example.danielarango2.danieldojokotlin.Models.Note
import kotlinx.android.synthetic.main.activity_new_note.*

class new_note : AppCompatActivity() {


    private var database : dbhelper?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        guardar.setOnClickListener{
            val title = titulo.text.toString()
            val body = texto.text.toString()
            var note = Note(title, body)
            database = dbhelper(this)
            database!!.insertNote(note)
            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }

        salir.setOnClickListener {

            val openMainActivity = Intent(this, MainActivity::class.java)
            startActivity(openMainActivity)
        }
    }
}
