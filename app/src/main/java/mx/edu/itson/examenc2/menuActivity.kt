package mx.edu.itson.examenc2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnDetalles: CardView = findViewById(R.id.btnDetalles)
        val btnGlobos: CardView = findViewById(R.id.btnGlobos)
        val btnPeluches: CardView = findViewById(R.id.btnPeluches)
        val btnRegalos: CardView = findViewById(R.id.btnRegalos)
        val btnTazas: CardView = findViewById(R.id.btnTazas)

        btnDetalles.setOnClickListener {
            abrirCategoria("Detalles")
        }

        btnGlobos.setOnClickListener {
            abrirCategoria("Globos")
        }

        btnPeluches.setOnClickListener {
            abrirCategoria("Peluches")
        }

        btnRegalos.setOnClickListener {
            abrirCategoria("Regalos")
        }

        btnTazas.setOnClickListener {
            abrirCategoria("Tazas")
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun abrirCategoria(categoria: String) {
        val intent = Intent(this, ProductosActivity::class.java)
        intent.putExtra("categoria", categoria)
        startActivity(intent)
    }
}