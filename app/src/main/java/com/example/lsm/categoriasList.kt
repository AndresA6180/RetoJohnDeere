package com.example.lsm

var categoriasList = mutableListOf(
    //Lista de todas las categorais con su lista de palabras y la imagen que le corresponde a la carta
    //de cada actividad,
    Categorias("Abecedario", subCategoriasList[0], R.raw.abecedario_cover),
    Categorias("Animales",subCategoriasList[1], R.raw.animales_cover),
    Categorias("Colores",subCategoriasList[2], R.raw.colores_cover),
    Categorias("Comida",subCategoriasList[3], R.raw.comida_cover),
    Categorias("Dias de la Semana", subCategoriasList[4], R.raw.semana_cover),
    Categorias("Meses del Año",subCategoriasList[5], R.raw.meses_cover),
    Categorias("Personas",subCategoriasList[6], R.raw.personas_cover),
    Categorias("Preguntas",subCategoriasList[7], R.raw.preguntas_cover),
    Categorias("Pronombres",subCategoriasList[8], R.raw.pronombres_covr),
    Categorias("Saludos y Cortesias",subCategoriasList[9], R.raw.saludos_cover),
    Categorias("Verduras", subCategoriasList[10], R.raw.vereduras_cover),
    Categorias("Frutas", subCategoriasList[11], R.raw.frutas_cover),
    Categorias("Tiempo", subCategoriasList[12], R.raw.tiempo_cover),
    Categorias("Pusetos profesionales", subCategoriasList[13], R.raw.profesiones_cover),
    Categorias("Ropa", subCategoriasList[14], R.raw.ropa_cover),
    Categorias("Transporte", subCategoriasList[15], R.raw.transporte_cover),
    Categorias("Verbos Comunes", subCategoriasList[16], R.raw.verbos_cover),
    Categorias("Cuerpo", subCategoriasList[17], R.raw.cuerpo_cover),
    Categorias("Preposiciones, Adjetivos, Sustantivos y Adverbios", subCategoriasList[18], R.raw.preposiciones_cover),
    Categorias("Numeros", subCategoriasList[19], R.raw.numeros_cover),
    Categorias("Verbos narrativos", subCategoriasList[20], R.raw.verbosnarrativos_cover),
    Categorias("Hogar", subCategoriasList[21], R.raw.hogar_cover),
    Categorias("Lugares", subCategoriasList[22], R.raw.lugares_cover)
)