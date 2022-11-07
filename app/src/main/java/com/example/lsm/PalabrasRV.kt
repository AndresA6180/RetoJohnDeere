package com.example.lsm

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PalabrasRV (
    val nombre: String,
    val local_video_url: Int?,
) : Parcelable