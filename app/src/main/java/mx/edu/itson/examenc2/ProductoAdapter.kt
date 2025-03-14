package mx.edu.itson.examenc2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductoAdapter(private val context: Context, private val productos: List<Producto>) : BaseAdapter() {
    override fun getCount(): Int = productos.size

    override fun getItem(position: Int): Any = productos[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val producto = productos[position]
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = inflater.inflate(R.layout.item_producto, null)

        val imgProducto: ImageView = vista.findViewById(R.id.imgProducto)
        val txtNombreProducto: TextView = vista.findViewById(R.id.txtNombreProducto)
        val txtPrecioProducto: TextView = vista.findViewById(R.id.txtPrecioProducto)

        imgProducto.setImageResource(producto.imagen)
        txtNombreProducto.text = producto.nombre
        txtPrecioProducto.text = "$${producto.precio}"

        return vista
    }
}