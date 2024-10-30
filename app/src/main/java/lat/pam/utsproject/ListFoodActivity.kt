package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappuccino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Kopi Hitam", "Kopi nikmat nyaman dilambung dan dari biji kopi pilihan", R.drawable.kopi_hitam),
            Food("Cireng", "Makanan khas Jawa Barat yang terbuat dari tepung kanji.", R.drawable.cireng),
            Food("Nasi Goreng", "Makanan berupa nasi yang digoreng dan dicampur.", R.drawable.nasigoreng)
        )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter

        val btnPesan: Button = findViewById(R.id.btnpesan)
        btnPesan.setOnClickListener {
            val foodNames = foodList.map { it.name }
            val intent = Intent(this, OrderActivity::class.java)
            intent.putStringArrayListExtra("foodNames", ArrayList(foodNames))
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}