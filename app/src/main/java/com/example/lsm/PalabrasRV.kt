package com.example.lsm

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Palabras contienen un nombre como identificador y su url para el video o imagen
@Parcelize
data class PalabrasRV (
    val nombre: String,
    val local_video_url: Int?,
) : Parcelable