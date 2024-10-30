package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil daftar nama makanan dari Intent
        val foodNames = intent.getStringArrayListExtra("foodNames") ?: arrayListOf()

        // Inisialisasi Spinner
        val spinnerFoodName: Spinner = findViewById(R.id.spinnerFoodName)

        // Adapter untuk Spinner
        val adapter = ArrayAdapter(this, R.layout.spinner_item, foodNames) // Use custom layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFoodName.adapter = adapter

        // Referensi ke input dan tombol
        val etServings: EditText = findViewById(R.id.etServings)
        val etName: EditText = findViewById(R.id.etName)
        val etNotes: EditText = findViewById(R.id.etNotes)
        val btnOrder: Button = findViewById(R.id.btnOrder)

        // Set onClickListener untuk tombol Order
        btnOrder.setOnClickListener {
            // Ambil nilai dari input
            val selectedFood = spinnerFoodName.selectedItem.toString()
            val servings = etServings.text.toString()
            val name = etName.text.toString()
            val notes = etNotes.text.toString()

            // Intent ke ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("selectedFood", selectedFood)
                putExtra("servings", servings)
                putExtra("name", name)
                putExtra("notes", notes)
            }
            startActivity(intent)
        }
    }
}