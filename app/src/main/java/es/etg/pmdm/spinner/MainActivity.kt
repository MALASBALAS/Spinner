package es.etg.pmdm.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Spinner
        val sp: Spinner = findViewById(R.id.spinner)
        sp.adapter = getAdapter() //Método con el adaptador


        // ListView
        val lv: ListView = findViewById(R.id.listView)
        lv.adapter = getAdapter()
        lv.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(view?.context, "Seleccionado $position", Toast.LENGTH_SHORT).show()
            }
        }

        // GridView
        val gv: GridView = findViewById(R.id.gridView)
        gv.adapter = getAdapter()
        gv.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(view?.context, "Seleccionado $position", Toast.LENGTH_SHORT).show()
            }
        }




    }

    fun getAdapter(): ArrayAdapter<CharSequence> {
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.lista_ciudades,
            android.R.layout.simple_spinner_item)
        return adapter;
    }
}
