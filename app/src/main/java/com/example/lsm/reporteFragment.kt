package com.example.lsm

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.lsm.databinding.FragmentReporteBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.transition.MaterialFade
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.SlideDistanceProvider
import com.google.firebase.database.*


class reporteFragment : Fragment() {

    private var _binding: FragmentReporteBinding? = null
    private val binding get()  = _binding!!
    lateinit var database : DatabaseReference
    lateinit var databaseUsuarios : DatabaseReference
    var listaTotalUsuarios = emptyList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough().apply {
            duration = 200L
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReporteBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = FirebaseDatabase.getInstance().getReference("Categorias")
        databaseUsuarios = FirebaseDatabase.getInstance().getReference("Usuarios")

        databaseUsuarios.ref.orderByChild("usuario").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children)
                    {
                        if(dataSnapshot.child("usuario").value != null){
                            listaTotalUsuarios = listaTotalUsuarios.plus(dataSnapshot.child("usuario").value as String)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("DbTest", "failed")
            }

        })

        init()

    }
    fun init() {
        val stk = binding.tableMain

        val tbrow0 = TableRow(requireActivity())



        val v0 = View(requireActivity())
        v0.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
        v0.setBackgroundColor(Color.BLACK);
        tbrow0.addView(v0)

        val tv0 = TextView(requireActivity())
        tv0.text = "#"
        tv0.text
        tv0.setTypeface(tv0.getTypeface(), Typeface.BOLD_ITALIC)
        tv0.setTextColor(Color.BLACK)
        tv0.gravity = Gravity.CENTER
        tv0.setPadding(10,10,10,10)
        tbrow0.addView(tv0)

        val v1 = View(requireActivity())
        v1.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
        v1.setBackgroundColor(Color.BLACK);
        tbrow0.addView(v1)

        val tv1 = TextView(requireActivity())
        tv1.text = "Categoria"
        tv1.setTypeface(tv1.getTypeface(), Typeface.BOLD_ITALIC)
        tv1.setTextColor(Color.BLACK)
        tv1.gravity = Gravity.CENTER
        tv1.setPadding(10,10,10,10)
        tbrow0.addView(tv1)

        val v2 = View(requireActivity())
        v2.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
        v2.setBackgroundColor(Color.BLACK);
        tbrow0.addView(v2)

        val tv2 = TextView(requireActivity())
        tv2.text = "Usuarios que contestaron"
        tv2.setTypeface(tv2.getTypeface(), Typeface.BOLD_ITALIC)
        tv2.setTextColor(Color.BLACK)
        tv2.gravity = Gravity.CENTER
        tv2.setPadding(10,10,10,10)
        tbrow0.addView(tv2)

        val v3 = View(requireActivity())
        v3.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
        v3.setBackgroundColor(Color.BLACK);
        tbrow0.addView(v3)

        val tv3 = TextView(requireActivity())
        tv3.text = "Usuarios sin contestar"
        tv3.setTypeface(tv3.getTypeface(), Typeface.BOLD_ITALIC)
        tv3.gravity = Gravity.CENTER
        tv3.setTextColor(Color.BLACK)
        tbrow0.layoutParams = LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        tv3.setPadding(10,10,10,10)
        tbrow0.addView(tv3)


        val v4 = View(requireActivity())
        v4.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
        v4.setBackgroundColor(Color.BLACK);
        tbrow0.addView(v4)


        stk.addView(tbrow0)

        var i = 0


        categoriasList.sortBy { it.nombre }
        for (categoria in categoriasList) {
            var listaUsuarios = emptyList<String>()
            var arrayAdapter: ArrayAdapter<*>



            database.ref.orderByChild("categoria").equalTo(categoria.nombre).addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (dataSnapshot in snapshot.children) {
                            if(dataSnapshot.child("usuarios").exists()){
                                listaUsuarios = dataSnapshot.child("usuarios").value as List<String>

                                i += 1

                                val tbrow = TableRow(requireActivity())

                                val v9 = View(requireActivity())
                                v9.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
                                v9.setBackgroundColor(Color.BLACK);
                                tbrow.addView(v9)

                                val t1v = TextView(requireActivity())
                                t1v.text = i.toString()
                                t1v.setTextColor(Color.BLACK)
                                t1v.gravity = Gravity.CENTER
                                t1v.width = 0
                                t1v.setPadding(10,10,10,10)
                                tbrow.addView(t1v)

                                val v5 = View(requireActivity())
                                v5.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
                                v5.setBackgroundColor(Color.BLACK);
                                tbrow.addView(v5)

                                val t2v = TextView(requireActivity())
                                t2v.text = categoria.nombre
                                t2v.setTextColor(Color.BLACK)
                                t2v.gravity = Gravity.CENTER
                                t2v.width = 0
                                t2v.setPadding(10,10,10,10)
                                tbrow.addView(t2v)

                                val v6 = View(requireActivity())
                                v6.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
                                v6.setBackgroundColor(Color.BLACK);
                                tbrow.addView(v6)

                                val t3v = MaterialButton(ContextThemeWrapper(requireActivity(), com.google.android.material.R.style.Widget_Material3_Button_OutlinedButton))
                                t3v.setBackgroundColor(resources.getColor(R.color.Fondo))
                                t3v.strokeWidth = 2
                                t3v.setStrokeColorResource(R.color.Highlight)
                                val params3 = TableRow.LayoutParams(
                                    TableRow.LayoutParams.WRAP_CONTENT,
                                    TableRow.LayoutParams.WRAP_CONTENT
                                )
                                params3.setMargins(10, 10, 10, 10)
                                t3v.layoutParams = params3
                                t3v.text = "Ver"
                                t3v.setOnClickListener {
                                    val dialog = Dialog(requireActivity())
                                    val materialFade = MaterialFade().apply {
                                        duration = 150L
                                    }

                                    dialog.setContentView(R.layout.dialog)
                                    var lista : ListView = dialog.findViewById(R.id.List) as ListView
                                    arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, listaUsuarios)
                                    lista.adapter = arrayAdapter

                                    var title : TextView = dialog.findViewById(R.id.textView6) as TextView
                                    title.text = "Usuarios han contestado"

                                    var button : ImageButton = dialog.findViewById(R.id.imageButton) as ImageButton
                                    button.setOnClickListener {
                                        dialog.dismiss()
                                    }

                                    dialog.show()
                                }
                                t3v.setPadding(10,10,10,10)
                                tbrow.addView(t3v)

                                val v7 = View(requireActivity())
                                v7.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
                                v7.setBackgroundColor(Color.BLACK);
                                tbrow.addView(v7)

                                val t4v = MaterialButton(ContextThemeWrapper(requireActivity(), com.google.android.material.R.style.Widget_Material3_Button_OutlinedButton))
                                t4v.setBackgroundColor(resources.getColor(R.color.Fondo))
                                t4v.setStrokeColorResource(R.color.Highlight)
                                t4v.strokeWidth = 2
                                val params4 = TableRow.LayoutParams(
                                    TableRow.LayoutParams.WRAP_CONTENT,
                                    TableRow.LayoutParams.WRAP_CONTENT
                                )
                                params4.setMargins(10, 10, 10, 10)
                                t4v.layoutParams = params4
                                t4v.text = "Ver"
                                t4v.setOnClickListener {
                                    val dialog = Dialog(requireActivity())
                                    dialog.setContentView(R.layout.dialog)
                                    var lista : ListView = dialog.findViewById(R.id.List) as ListView

                                    val usuariosNoContestados = listaTotalUsuarios.minus(listaUsuarios)

                                    arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, usuariosNoContestados)
                                    lista.adapter = arrayAdapter

                                    var title : TextView = dialog.findViewById(R.id.textView6) as TextView
                                    title.text = "Usuarios que no han contestado"

                                    var button : ImageButton = dialog.findViewById(R.id.imageButton) as ImageButton
                                    button.setOnClickListener {
                                        dialog.dismiss()
                                    }

                                    dialog.show()
                                }
                                t4v.setPadding(10,10,10,10)
                                tbrow.addView(t4v)

                                val v8 = View(requireActivity())
                                v8.layoutParams = TableRow.LayoutParams(1, TableRow.LayoutParams.MATCH_PARENT)
                                v8.setBackgroundColor(Color.BLACK);
                                tbrow.addView(v8)



                                stk.addView(tbrow)
                            }
                        }
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    Log.i("DbTest", "failed")
                }
            })





        }
    }

}