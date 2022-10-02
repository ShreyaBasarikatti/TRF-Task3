package com.example.trf_task1

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class signuppage : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    private var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signuppage)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
       // registerUser()
    }
    fun registerUser(view: View) {

        var name: String = findViewById<EditText>(R.id.name).text.toString()
        var email: String = findViewById<EditText>(R.id.email).text.toString()
        var age: String = findViewById<EditText>(R.id.age).text.toString()
        var phone: String = findViewById<EditText>(R.id.phone).text.toString()
        var password: String = findViewById<EditText>(R.id.password).text.toString()
        var password2: String = findViewById<EditText>(R.id.password2).text.toString()
        val user1 = hashMapOf<String,Any>(
            "name" to name,
            "age" to age,
            "phoneNo" to phone
        )
        db?.collection("Users")?.document(email)
            ?.set(user1)
            ?.addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            ?.addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

        if(password.equals(password2)){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, Loginactivity::class.java))
                    } else {
                        Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
