package com.example.lsm

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Categorias (
    val nombre : String,
    val sub_categoria: List<PalabrasRV>,
    val url_imagen : Int?
) : Parcelable