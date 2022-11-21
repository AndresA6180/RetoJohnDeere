package com.example.lsm

//Password y nombre de usuario
data class Usuario (
    var usuario : String,
    var password : String,
    var listaCompletadas : List<String>
)