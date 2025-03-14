package mx.edu.itson.examenc2

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {
    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var adapter: ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        val categoria = intent.getStringExtra("categoria") ?: "Categoría"
        val txtTitulo: TextView = findViewById(R.id.txtTitulo)
        txtTitulo.text = categoria

        listaProductos = ArrayList()
        cargarProductos(categoria)

        adapter = ProductoAdapter(this, listaProductos)
        val listView: ListView = findViewById(R.id.listViewProductos)
        listView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun cargarProductos(categoria: String) {
        when (categoria) {
            "Detalles" -> {
                listaProductos.add(Producto("Detalle 1", 280, R.drawable.cumplebotanas))
                listaProductos.add(Producto("Detalle 2", 320, R.drawable.cumplecheve))
                listaProductos.add(Producto("Detalle 3", 330, R.drawable.cumpleescolar))
                listaProductos.add(Producto("Detalle 4", 190, R.drawable.cumplepaletas))
                listaProductos.add(Producto("Detalle 5", 150, R.drawable.cumplesnack))
                listaProductos.add(Producto("Detalle 6", 370, R.drawable.cumplevinos))
            }
            "Globos" -> {
                listaProductos.add(Producto("Globo 1", 240, R.drawable.globoamor))
                listaProductos.add(Producto("Globo 2", 820, R.drawable.globocumple))
                listaProductos.add(Producto("Globo 3", 260, R.drawable.globofestejo))
                listaProductos.add(Producto("Globo 4", 760, R.drawable.globonum))
                listaProductos.add(Producto("Globo 5", 450, R.drawable.globoregalo))
                listaProductos.add(Producto("Globo 6", 240, R.drawable.globos))
            }
            "Peluches" -> {
                listaProductos.add(Producto("Mario", 320, R.drawable.peluchemario))
                listaProductos.add(Producto("Minecraft", 320, R.drawable.pelucheminecraft))
                listaProductos.add(Producto("Peppa Pig", 290, R.drawable.peluchepeppa))
                listaProductos.add(Producto("Sonic", 330, R.drawable.peluches))
                listaProductos.add(Producto("Stitch", 280, R.drawable.peluchesony))
                listaProductos.add(Producto("Varios", 195, R.drawable.peluchestich))
            }
            "Regalos" -> {
                listaProductos.add(Producto("Regalo 1", 80, R.drawable.regaloazul))
                listaProductos.add(Producto("Regalo 2", 290, R.drawable.regalobebe))
                listaProductos.add(Producto("Regalo 3", 140, R.drawable.regalocajas))
                listaProductos.add(Producto("Regalo 4", 85, R.drawable.regalocolores))
                listaProductos.add(Producto("Regalo 5", 85, R.drawable.regalos))
                listaProductos.add(Producto("Regalo 6", 75, R.drawable.regalovarios))
            }
            "Tazas" -> {
                listaProductos.add(Producto("Taza 1", 120, R.drawable.tazaabuela))
                listaProductos.add(Producto("Taza 2", 120, R.drawable.tazalove))
                listaProductos.add(Producto("Taza 3", 260, R.drawable.tazaquiero))
                listaProductos.add(Producto("Taza 4", 280, R.drawable.tazas))
            }
        }
    }
}