package com.example.lsm

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Objeto de categorial con nombre, lista de palabras y imagen que se
//despliega en cada carta de cada categoria
@Parcelize
data class Categorias (
    val nombre : String,
    val sub_categoria: List<PalabrasRV>,
    val url_imagen : Int?
) : Parcelable