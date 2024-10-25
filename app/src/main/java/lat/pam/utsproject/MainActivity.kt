package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText = findViewById<EditText>(R.id.etUsername)
        val passwordEditText = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val registerTextView = findViewById<TextView>(R.id.tvRegister)

        val dummyUsername = "admin"
        val dummyPassword = "admin"

        loginButton.setOnClickListener {
            val inputUsername = usernameEditText.text.toString()
            val inputPassword = passwordEditText.text.toString()

            if (inputUsername == dummyUsername && inputPassword == dummyPassword) {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ListFoodActivity::class.java))
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        registerTextView.setOnClickListener {
            Toast.makeText(this, "Register clicked", Toast.LENGTH_SHORT).show()
        }
    }
}