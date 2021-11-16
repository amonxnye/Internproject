package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Connection to the UI element
        var usernameinput = findViewById<EditText>(R.id.usernameid)

        //Variable collectin information from the UI element
        var Storageofinput  =  usernameinput.text

        var sendbtn = findViewById<Button>(R.id.sendbtnid)

        sendbtn.setOnClickListener {
            AddtoDatabase(Storageofinput.toString());

        }


    }

    fun AddtoDatabase(inputddata : String){

        FirebaseApp.initializeApp(this)

        val db = FirebaseFirestore.getInstance()
        // Create a new user with a first and last name
        // Create a new user with a first and last name
        val user: MutableMap<String, Any> = HashMap()
        user["userinput"] = inputddata

// Add a new document with a generated ID

// Add a new document with a generated ID
        db.collection("Userdata")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    "MainActivity",
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
                Toast.makeText(this, "You have sent to the Database, Successfully", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e -> Log.w("MainActivity", "Error adding document", e) }
    }





}