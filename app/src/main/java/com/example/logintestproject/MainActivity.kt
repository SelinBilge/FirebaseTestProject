package com.example.logintestproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import com.google.firebase.analytics.FirebaseAnalytics

import com.google.android.gms.auth.api.signin.GoogleSignIn

import com.google.android.gms.auth.api.signin.GoogleSignInAccount

import com.google.android.gms.auth.api.signin.GoogleSignInClient

import com.google.android.gms.auth.api.signin.GoogleSignInOptions

import com.google.android.gms.common.SignInButton

import com.google.android.gms.common.api.ApiException

import com.google.android.gms.tasks.OnCompleteListener

import com.google.android.gms.tasks.Task

import com.google.firebase.auth.AuthCredential

import com.google.firebase.auth.AuthResult

import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.FirebaseUser

import com.google.firebase.auth.GoogleAuthProvider


class MainActivity : AppCompatActivity() {

    private var clickNum = 0
    private lateinit var textView : TextView
    private lateinit var analytics : FirebaseAnalytics


    private lateinit var mAuth: FirebaseAuth

    @SuppressLint("SetTextI18n", "InvalidAnalyticsName")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        textView = findViewById(R.id.myText)
        analytics = FirebaseAnalytics.getInstance(this) // google anatytics for button

        val upButton = findViewById<Button>(R.id.button)
        upButton.setOnClickListener {
            clickNum++;
            textView.text = "Value is $clickNum"
            analytics.logEvent("button clicked", null)
        }

         */


        mAuth = FirebaseAuth.getInstance()

        val user = mAuth.currentUser

        Handler().postDelayed({

            if (user != null){ // is already logged in
                val dashboardIntent = Intent(this, DashboardActivity::class.java)
                startActivity(dashboardIntent)
                finish()

            } else { // user authenticate with google
                val signInIntent = Intent(this, SignInActivity::class.java)
                startActivity(signInIntent)
                finish()
            }

        },2000)



    }



}