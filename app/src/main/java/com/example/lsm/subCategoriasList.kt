package com.example.lsm

//Cada una de las categorias tiene una lista de palabras
//Estas son las listas de las palabras
//Cada lista de palabra tiene varias palabras y cada una tiene un nombre y su url para el video o la imagen
var subCategoriasList = mutableListOf(

    mutableListOf(PalabrasRV("A",R.raw.a ),PalabrasRV("B",R.raw.b),PalabrasRV("C",R.raw.c),PalabrasRV("D",R.raw.d),
        PalabrasRV("E",R.raw.e),PalabrasRV("F",R.raw.f),PalabrasRV("G",R.raw.g),PalabrasRV("H",R.raw.h),PalabrasRV("I",R.raw.i),
        PalabrasRV("J",R.raw.j_web),PalabrasRV("K",R.raw.k_web),PalabrasRV("L",R.raw.l),PalabrasRV("Ll",R.raw.ll_web),PalabrasRV("M",R.raw.m),PalabrasRV("N",R.raw.n),
        PalabrasRV("Ñ",R.raw.nie_web),PalabrasRV("O",R.raw.o),PalabrasRV("P",R.raw.p),PalabrasRV("Q",R.raw.q_web),PalabrasRV("R",R.raw.r),PalabrasRV("Rr",R.raw.rr_web),
        PalabrasRV("T",R.raw.t),PalabrasRV("U",R.raw.u),PalabrasRV("V",R.raw.v),PalabrasRV("W",R.raw.w),PalabrasRV("X",R.raw.x_web),
        PalabrasRV("Y",R.raw.y),PalabrasRV("Z",R.raw.z_web)),

    mutableListOf(PalabrasRV("Abeja",R.raw.abeja_web), PalabrasRV("Aguila",R.raw.aguila_web), PalabrasRV("Araña",R.raw.arana_web), PalabrasRV("Ardilla",R.raw.ardilla_web),
        PalabrasRV("Burro",R.raw.burro_web),PalabrasRV("Caballo",R.raw.caballo_web),PalabrasRV("Cerdo",R.raw.cerdo_web),PalabrasRV("Chango",R.raw.chango_web),PalabrasRV("Conejo",R.raw.conejo_web),
        PalabrasRV("Gato",R.raw.gato_web),PalabrasRV("Gorila",R.raw.gorila_web),PalabrasRV("Gusano",R.raw.gusano_web),PalabrasRV("Jirafa",R.raw.jirafa_web),PalabrasRV("Leon",R.raw.leon_web),
        PalabrasRV("Mariposa",R.raw.mariposa_web),PalabrasRV("Oso",R.raw.oso_web), PalabrasRV("Pajaro",R.raw.pajaro_web), PalabrasRV("Paloma",R.raw.paloma_web), PalabrasRV("Pato",R.raw.pato_web),
        PalabrasRV("Perro",R.raw.perro_web), PalabrasRV("Pez",R.raw.pez_web), PalabrasRV("Raton",R.raw.raton_web), PalabrasRV("Tigre",R.raw.tigre_web), PalabrasRV("Toro",R.raw.toro_web),
        PalabrasRV("Tortuga",R.raw.tortuga_web), PalabrasRV("Vaca",R.raw.vaca_web), PalabrasRV("Vibora",R.raw.vibora_web)),

    mutableListOf(PalabrasRV("Amarillo", R.raw.amarillocolor_web), PalabrasRV("Azul",R.raw.azulcolor_web), PalabrasRV("Blanco",R.raw.blancolor_web), PalabrasRV("Cafe",R.raw.cafecolor_web), PalabrasRV("Gris",R.raw.griscolor_web),
        PalabrasRV("Morado",R.raw.moradocolor_web), PalabrasRV("Naranja",R.raw.naranjacolor_web), PalabrasRV("Negro",R.raw.negrocolor_web), PalabrasRV("Oro",R.raw.orocolor_web), PalabrasRV("Plata",R.raw.platacolor_web),
        PalabrasRV("Rojo",R.raw.rojocolor_web), PalabrasRV("Rosa",R.raw.rosacolor_web), PalabrasRV("Verde",R.raw.verdecolor_web)),

    mutableListOf(PalabrasRV("Aceite", R.raw.aceite_web), PalabrasRV("Agua", R.raw.agua_web), PalabrasRV("Arroz",R.raw.arroz_web), PalabrasRV("Azucar",R.raw.azucar_web), PalabrasRV("Cafe",R.raw.cafe_web),
        PalabrasRV("Caldo",R.raw.caldo_web), PalabrasRV("Carne",R.raw.carne_web), PalabrasRV("Cerveza",R.raw.cerveza_web), PalabrasRV("Chile",R.raw.chile_web), PalabrasRV("Chocolate",R.raw.chocolate_web),
        PalabrasRV("Coca Cola",R.raw.cocacola_web), PalabrasRV("Dulce",R.raw.dulce_web), PalabrasRV("Ensalada",R.raw.ensalada_web), PalabrasRV("Frijol",R.raw.frijol_web), PalabrasRV("Fruta",R.raw.fruta_web),
        PalabrasRV("Galleta",R.raw.galleta_web), PalabrasRV("Hamburguesa",R.raw.hamburguesa_web), PalabrasRV("Huevo",R.raw.huevo_web), PalabrasRV("Leche",R.raw.leche_web), PalabrasRV("Pan",R.raw.pan_web),
        PalabrasRV("Pastel",R.raw.pastel_web), PalabrasRV("Pescado",R.raw.pescado_web), PalabrasRV("Pizza",R.raw.pizza_web), PalabrasRV("Pollo",R.raw.pollo_web), PalabrasRV("Queso",R.raw.queso_web),
        PalabrasRV("Refresco",R.raw.refresco_web), PalabrasRV("Sopa",R.raw.sopa_web), PalabrasRV("Taco",R.raw.taco_web), PalabrasRV("Tortilla",R.raw.tortilla_web), PalabrasRV("Verdura",R.raw.verdura_web)),

    mutableListOf(PalabrasRV("Domingo",R.raw.domingo_web),PalabrasRV("Lunes",R.raw.lunes_web), PalabrasRV("Martes",R.raw.martes_web), PalabrasRV("Miercoles",R.raw.miercoles_web), PalabrasRV("Jueves",R.raw.jueves_web),
        PalabrasRV("Viernes",R.raw.viernes_web), PalabrasRV("Sabado",R.raw.sabado_web)),

    mutableListOf(PalabrasRV("Enero",R.raw.enero_web), PalabrasRV("Febrero",R.raw.febrero_web), PalabrasRV("Marzo",R.raw.marzo_web), PalabrasRV("Abril",R.raw.abril_web), PalabrasRV("Mayo",R.raw.mayo_web),
        PalabrasRV("Junio",R.raw.junio_web), PalabrasRV("Julio",R.raw.julio_web), PalabrasRV("Agosto",R.raw.agosto_web), PalabrasRV("Septiembre",R.raw.septiembre_web), PalabrasRV("Octubre",R.raw.octubre_web),
        PalabrasRV("Noviembre",R.raw.noviembre_web), PalabrasRV("Diciembre",R.raw.diciembre_web)),

    mutableListOf(PalabrasRV("Abuela",R.raw.abuela_web), PalabrasRV("Abuelo",R.raw.abuelo_web), PalabrasRV("Adulto",R.raw.adulto_web), PalabrasRV("Amante",R.raw.amante_web), PalabrasRV("Amiga",R.raw.amiga_web),
        PalabrasRV("Amigo",R.raw.amigo_web), PalabrasRV("Anciano",R.raw.anciano_web), PalabrasRV("Bebe",R.raw.bebe_web), PalabrasRV("Bisabuela",R.raw.bisabuela_web), PalabrasRV("Bisabuelo",R.raw.bisabuelo_web), PalabrasRV("Bisnieta",R.raw.bisnieta_web),
        PalabrasRV("Bisnieto",R.raw.bisnieto_web), PalabrasRV("Ciego",R.raw.ciego_web), PalabrasRV("Compañero",R.raw.companero_web), PalabrasRV("Cuñada",R.raw.cunada_web), PalabrasRV("Cuñado",R.raw.cunado_web), PalabrasRV("Divorciado",R.raw.divorciado_web),
        PalabrasRV("Esposa",R.raw.esposa_web), PalabrasRV("Esposo",R.raw.esposo_web), PalabrasRV("Hermana",R.raw.hermana_web), PalabrasRV("Hermano",R.raw.hermano_web), PalabrasRV("Hija",R.raw.hija_web), PalabrasRV("Hijastra",R.raw.hijastra_web),
        PalabrasRV("Hijastro",R.raw.hijastro_web), PalabrasRV("Hijo",R.raw.hijo_web), PalabrasRV("Hombre",R.raw.hombre_web), PalabrasRV("Huerfano",R.raw.huerfano_web), PalabrasRV("Madrastra",R.raw.madrastra_web), PalabrasRV("Madrina",R.raw.madrina_web),
        PalabrasRV("Mama",R.raw.mama_web), PalabrasRV("Matrimonio",R.raw.matrimonio_web), PalabrasRV("Media hermana",R.raw.mediahermana_web), PalabrasRV("Medio hermano",R.raw.mediohermano_web), PalabrasRV("Mujer",R.raw.mujer_web), PalabrasRV("Nieta",R.raw.nieta_web),
        PalabrasRV("Nieto",R.raw.nieto_web), PalabrasRV("Niña",R.raw.nina_web), PalabrasRV("Niño",R.raw.nino_web), PalabrasRV("Novia",R.raw.novia_web), PalabrasRV("Novio",R.raw.novio_web), PalabrasRV("Nuera",R.raw.nuera_web), PalabrasRV("Oyente",R.raw.oyente_web),
        PalabrasRV("Padrastro",R.raw.padrastro_web), PalabrasRV("Padrino",R.raw.padrino_web), PalabrasRV("Papa",R.raw.papa_web), PalabrasRV("Pareja",R.raw.pareja_web), PalabrasRV("Persona",R.raw.persona_web), PalabrasRV("Prima",R.raw.prima_web), PalabrasRV("Primo",R.raw.primo_web),
        PalabrasRV("Señor",R.raw.senor_web), PalabrasRV("Señora",R.raw.senora_web), PalabrasRV("Señorita",R.raw.senorita_web), PalabrasRV("Separado",R.raw.separado_web), PalabrasRV("Sobrina",R.raw.sobrina_web), PalabrasRV("Sobrino",R.raw.sobrino_web), PalabrasRV("Soltero",R.raw.soltero_web),
        PalabrasRV("Sordo",R.raw.sordo_web), PalabrasRV("Suegra",R.raw.suegra_web), PalabrasRV("Suegro",R.raw.suegro_web), PalabrasRV("Tia",R.raw.tia_web), PalabrasRV("Tio",R.raw.tio_web), PalabrasRV("Union Libre",R.raw.unionlibre_web), PalabrasRV("Vecino",R.raw.vecino_web),
        PalabrasRV("Viudo",R.raw.viudo_web), PalabrasRV("Yerno",R.raw.yerno_web)),

    mutableListOf(PalabrasRV("¿Como?",R.raw.como_web), PalabrasRV("¿Cual?",R.raw.cual_web), PalabrasRV("¿Cuando?",R.raw.cuando_web), PalabrasRV("¿Cuanto?",R.raw.cuanto_web), PalabrasRV("¿Donde?",R.raw.donde_web),
        PalabrasRV("¿Para que?",R.raw.paraque_web), PalabrasRV("¿Por que?",R.raw.porque_web), PalabrasRV("¿Que?",R.raw.que_web), PalabrasRV("¿Quien?",R.raw.quien_web)),

    mutableListOf(PalabrasRV("El",R.raw.el_web), PalabrasRV("Ella",R.raw.ella_web), PalabrasRV("Ellos",R.raw.ellos_web), PalabrasRV("Nosotros",R.raw.nosotros_web), PalabrasRV("Tu",R.raw.tu_web), PalabrasRV("Ustedes",R.raw.ustedes_web), PalabrasRV("Yo",R.raw.yo_web)),

    mutableListOf(PalabrasRV("Adios",R.raw.adios_web), PalabrasRV("Bien",R.raw.bien_web), PalabrasRV("Buenas noches",R.raw.buenasnoches_web), PalabrasRV("Buenas tardes",R.raw.buenastardes_web), PalabrasRV("Buenos dias",R.raw.buenosdias_web), PalabrasRV("¿Como estas?",R.raw.comoestas_web),
        PalabrasRV("¿Como te llamas?",R.raw.comotellamas_web), PalabrasRV("De nada",R.raw.denada_web), PalabrasRV("Gracias",R.raw.gracias_web), PalabrasRV("Gusto de conocerte",R.raw.gustodeconocerte_web), PalabrasRV("Hola",R.raw.hola_web), PalabrasRV("Mal",R.raw.mal_web), PalabrasRV("Mas o menos",R.raw.masomenos_web),
        PalabrasRV("Nos vemos",R.raw.nosvemos_web), PalabrasRV("Por favor",R.raw.porfavor_web)),

    mutableListOf(PalabrasRV("Aguacate",R.raw.aguacate_web), PalabrasRV("Ajo",R.raw.ajo_web), PalabrasRV("Betabel",R.raw.betabel_web), PalabrasRV("Calabacita",R.raw.calabacita_web), PalabrasRV("Calabaza",R.raw.calabaza_web), PalabrasRV("Camote",R.raw.camote_web), PalabrasRV("Chicharo",R.raw.chicharo_web),
        PalabrasRV("Elote",R.raw.elote_web),PalabrasRV("Frijol",R.raw.frijolverdura_web),PalabrasRV("Hongo",R.raw.hongo_web),PalabrasRV("Nopal",R.raw.nopal_web),PalabrasRV("Papa", R.raw.papaverdura_web),PalabrasRV("Cebolla",R.raw.cebolla_web),PalabrasRV("Chile", R.raw.chileverdura_web),
        PalabrasRV("Jitomate",R.raw.jitomate_web),PalabrasRV("Lechuga",R.raw.lechuga_web), PalabrasRV("Pepino",R.raw.pepino_web),PalabrasRV("Zanahoria",R.raw.zanahoria_web)),

    mutableListOf(PalabrasRV("Almendra",R.raw.almendra_web),PalabrasRV("Cereza",R.raw.cereza_web),PalabrasRV("Coco",R.raw.coco_web), PalabrasRV("Durazno",R.raw.durazno_web),PalabrasRV("Jicama",R.raw.jicama_web),PalabrasRV("Limon",R.raw.limon_web), PalabrasRV("Manzana",R.raw.manzana_web),
        PalabrasRV("Melon",R.raw.melon_web),PalabrasRV("Naranja",R.raw.naranja_web),PalabrasRV("Pera",R.raw.pera_web), PalabrasRV("Piña",R.raw.pina_web), PalabrasRV("Sandia",R.raw.sandia_web), PalabrasRV("Tamarindo",R.raw.tamarindo_web), PalabrasRV("Uva",R.raw.uva_web), PalabrasRV("Fresa",R.raw.fresa_web),
        PalabrasRV("Guayaba",R.raw.guayaba_web), PalabrasRV("Jamaica",R.raw.jamaica_web), PalabrasRV("Mango",R.raw.mango_web),PalabrasRV("Nuez",R.raw.nuez_web), PalabrasRV("Papaya",R.raw.papaya_web), PalabrasRV("Platano",R.raw.platano_web), PalabrasRV("Toronja",R.raw.toronja_web)),

    mutableListOf(PalabrasRV("Ahora",R.raw.ahora_web),PalabrasRV("Ahorita",R.raw.ahorita_web), PalabrasRV("Aire",R.raw.aire_web), PalabrasRV("Año",R.raw.ano_web), PalabrasRV("Antier",R.raw.antier_web), PalabrasRV("A veces",R.raw.aveces_web), PalabrasRV("Ayer",R.raw.ayer_web), PalabrasRV("Calendario",R.raw.calendario_web),
        PalabrasRV("Calor",R.raw.calor_web), PalabrasRV("Cumpleaños",R.raw.cumpleanos_web), PalabrasRV("Despues",R.raw.despues_web), PalabrasRV("Dia",R.raw.dia_web), PalabrasRV("Edad",R.raw.edad_web), PalabrasRV("Fecha",R.raw.fecha_web), PalabrasRV("Frio",R.raw.frio_web), PalabrasRV("Futuro",R.raw.futuro_web), PalabrasRV("Hasta",R.raw.hasta_web),
        PalabrasRV("Hora",R.raw.hora_web), PalabrasRV("Hoy",R.raw.hoy_web), PalabrasRV("Invierno",R.raw.invierno_web), PalabrasRV("Mañana",R.raw.manana_web), PalabrasRV("Mediodia",R.raw.mediodia_web), PalabrasRV("Mes",R.raw.mes_web), PalabrasRV("Mientras",R.raw.mientras_web), PalabrasRV("Minuto",R.raw.minuto_web),
        PalabrasRV("Noche",R.raw.noche_web), PalabrasRV("Otoño",R.raw.otono_web), PalabrasRV("Otra vez",R.raw.otravez_web), PalabrasRV("Otro",R.raw.otro_web), PalabrasRV("Pasado",R.raw.pasado_web), PalabrasRV("Presente",R.raw.presente_web), PalabrasRV("Primavera",R.raw.primavera_web), PalabrasRV("Primera vez",R.raw.primeravez_web),
        PalabrasRV("Proximo",R.raw.proximo_web), PalabrasRV("Semana",R.raw.semana_web), PalabrasRV("Siempre",R.raw.siempre_web), PalabrasRV("Tarde",R.raw.tarde_web), PalabrasRV("Temprano",R.raw.temprano_web), PalabrasRV("Una vez",R.raw.unavez_web), PalabrasRV("Verano",R.raw.verano_web),
        PalabrasRV("Viento",R.raw.viento_web)),

    mutableListOf(PalabrasRV("Abogado",R.raw.abogado_web),PalabrasRV("Actor",R.raw.actor_web),PalabrasRV("Albañil",R.raw.albanil_web),PalabrasRV("Alumno",R.raw.alumno_web), PalabrasRV("Arquitecto",R.raw.arquitecto_web), PalabrasRV("Bombero",R.raw.bombero_web), PalabrasRV("Carpintero",R.raw.carpintero_web), PalabrasRV("Chofer",R.raw.chofer_web),
        PalabrasRV("Dentista",R.raw.dentista_web),PalabrasRV("Diputado",R.raw.diputado_web), PalabrasRV("Director",R.raw.director_web), PalabrasRV("Enfermera",R.raw.enfermera_web), PalabrasRV("Gobernador",R.raw.gobernador_web), PalabrasRV("Guardia",R.raw.guardia_web), PalabrasRV("Ingeniero",R.raw.ingeniero_web),
        PalabrasRV("Interprete",R.raw.interprete_web), PalabrasRV("Jefe",R.raw.jefe_web), PalabrasRV("Licenciado",R.raw.licenciado_web), PalabrasRV("Lider",R.raw.lider_web), PalabrasRV("Maestro",R.raw.maestro_web), PalabrasRV("Meecanico",R.raw.mecanico_web), PalabrasRV("Medico",R.raw.medico_web), PalabrasRV("Meseero",R.raw.mesero_web),
        PalabrasRV("Policia",R.raw.policia_web), PalabrasRV("Presidentee",R.raw.presidente_web), PalabrasRV("Profesor",R.raw.profesor_web), PalabrasRV("Psicologo",R.raw.psicologo_web), PalabrasRV("Senador",R.raw.senador_web), PalabrasRV("Soldado",R.raw.soldado_web), PalabrasRV("Taxista",R.raw.taxista_web), PalabrasRV("Tecnico",R.raw.tecnico_web),
        PalabrasRV("Vendedor",R.raw.vendedor_web)),

    mutableListOf(PalabrasRV("Abrigo",R.raw.abrigo_web), PalabrasRV("Brasier",R.raw.brasier_web), PalabrasRV("Bufanda",R.raw.bufanda_web), PalabrasRV("Calzon",R.raw.calzon_web), PalabrasRV("Camisa",R.raw.camisa_web), PalabrasRV("Corbata",R.raw.corbata_web), PalabrasRV("Falda",R.raw.falda_web), PalabrasRV("Medias",R.raw.medias_web),
        PalabrasRV("Pantalon",R.raw.pantalon_web), PalabrasRV("Tenis",R.raw.tenis_web), PalabrasRV("Vestido",R.raw.vestido_web), PalabrasRV("Zapatos",R.raw.zapatos_web)),

    mutableListOf(PalabrasRV("Avion",R.raw.avion_web), PalabrasRV("Barco",R.raw.barco_web), PalabrasRV("Bicicleta",R.raw.bicicleta_web), PalabrasRV("Camion",R.raw.camion_web), PalabrasRV("Carro",R.raw.carro_web), PalabrasRV("Cdeautobuses",R.raw.cdeautobuses_web), PalabrasRV("Helicoptero",R.raw.helicoptero_web),
        PalabrasRV("Metro",R.raw.metro_web), PalabrasRV("Motocicleta",R.raw.motocicleta_web), PalabrasRV("Taxi",R.raw.taxi_web), PalabrasRV("Transporte",R.raw.transporte_web), PalabrasRV("Tren",R.raw.tren_web)),

    mutableListOf(PalabrasRV("Aprender",R.raw.aprender_web), PalabrasRV("Avisar",R.raw.avisar_web), PalabrasRV("Cuidar",R.raw.cuidar_web), PalabrasRV("Dormir",R.raw.dormir_web), PalabrasRV("Escribir",R.raw.escribir_web), PalabrasRV("Hacer",R.raw.hacer_web ), PalabrasRV("Necesitar",R.raw.necesitar_web),
        PalabrasRV("Poder",R.raw.poder_web), PalabrasRV("Preguntar",R.raw.preguntar_web), PalabrasRV("Sentar",R.raw.sentar_web), PalabrasRV("Ver",R.raw.ver_web), PalabrasRV("Ayudar",R.raw.ayudar_web), PalabrasRV("Comer",R.raw.comer_web), PalabrasRV("Comprar",R.raw.comprar_web), PalabrasRV("Creer",R.raw.creer_web),
        PalabrasRV("Dar",R.raw.dar_web), PalabrasRV("Decir",R.raw.decir_web), PalabrasRV("Descansar",R.raw.descansar_web), PalabrasRV("Empezar",R.raw.empezar_web), PalabrasRV("Enseñar",R.raw.ensenar_web), PalabrasRV("Entender",R.raw.entender_web), PalabrasRV("Esperar",R.raw.esperar_web), PalabrasRV("Estudiar",R.raw.estudiar_web),
        PalabrasRV("Explicar",R.raw.explicar_web), PalabrasRV("Hablar",R.raw.hablar_web), PalabrasRV("Jugar",R.raw.jugar_web), PalabrasRV("Limpiar",R.raw.limpiar_web), PalabrasRV("Olvidar",R.raw.olvidar_web), PalabrasRV("Pagar",R.raw.pagar_web), PalabrasRV("Pensar",R.raw.pensar_web), PalabrasRV("Perder",R.raw.perder_web),
        PalabrasRV("Platicar",R.raw.platicar_web), PalabrasRV("Terminar",R.raw.terminar_web), PalabrasRV("Trabajar",R.raw.trabajar_web),PalabrasRV("Vender",R.raw.vender_web), PalabrasRV("Vivir",R.raw.vivir_web)),

    mutableListOf(PalabrasRV("Boca",R.raw.boca_web), PalabrasRV("Cabeza",R.raw.cabeza_web),PalabrasRV("Cara",R.raw.cara_web), PalabrasRV("Cejas",R.raw.cejas_web), PalabrasRV("Corazon",R.raw.corazon_web), PalabrasRV("Estomago",R.raw.estomago_web), PalabrasRV("Hueso",R.raw.hueso_web), PalabrasRV("Mano",R.raw.mano_web),
        PalabrasRV("Nariz",R.raw.nariz_web), PalabrasRV("Ojos",R.raw.ojos_web), PalabrasRV("Oreja",R.raw.oreja_web), PalabrasRV("Pestañas",R.raw.pestanas_web), PalabrasRV("Piel",R.raw.piel_web), PalabrasRV("Pies",R.raw.pies_web), PalabrasRV("Sangre",R.raw.sangre_web)),

    mutableListOf(PalabrasRV("Caliente",R.raw.caliente_web), PalabrasRV("Cariño",R.raw.carino_web), PalabrasRV("Cobarde",R.raw.cobarde_web), PalabrasRV("Despacio",R.raw.despacio_web), PalabrasRV("Diploma",R.raw.diploma_web), PalabrasRV("Ejemplo",R.raw.ejemplo_web), PalabrasRV("Flojo",R.raw.flojo_web), PalabrasRV("Hambre",R.raw.hambre_web),
        PalabrasRV("Loco",R.raw.loco_web), PalabrasRV("Problema",R.raw.problema_web), PalabrasRV("Si",R.raw.si_web), PalabrasRV("Tonto",R.raw.tonto_web), PalabrasRV("Verguenza",R.raw.verguenza_web), PalabrasRV("Abajo",R.raw.abajo_web), PalabrasRV("Aburrido",R.raw.aburrido_web), PalabrasRV("Accidente",R.raw.accidente_web),
        PalabrasRV("Afortunado",R.raw.afortunado_web), PalabrasRV("Algunos",R.raw.algunos_web), PalabrasRV("Alto/Estatura",R.raw.altoestatura_web), PalabrasRV("Amable",R.raw.amable_web), PalabrasRV("Antes", R.raw.antes_web), PalabrasRV("Arriba",R.raw.arriba_web), PalabrasRV("Asustado",R.raw.asustado_web), PalabrasRV("Atencion/Atento",R.raw.atencionatento_web),
        PalabrasRV("Baboso",R.raw.baboso_web), PalabrasRV("Bonito",R.raw.bonito_web), PalabrasRV("Broma",R.raw.broma_web), PalabrasRV("Bueno",R.raw.bueno_web), PalabrasRV("Cada",R.raw.cada_web), PalabrasRV("Cansado",R.raw.cansado_web), PalabrasRV("Celoso",R.raw.celoso_web), PalabrasRV("Chaparro",R.raw.chaparro_web), PalabrasRV("Chistoso",R.raw.chistoso_web),
        PalabrasRV("Contento",R.raw.contento_web), PalabrasRV("Curioso",R.raw.curioso_web), PalabrasRV("Debil",R.raw.debil_web), PalabrasRV("Decente",R.raw.decente_web), PalabrasRV("Delgado",R.raw.delgado_web), PalabrasRV("Diferente",R.raw.diferente_web), PalabrasRV("Dificil",R.raw.dificil_web), PalabrasRV("Duda",R.raw.duda_web), PalabrasRV("Egoista",R.raw.egoista_web),
        PalabrasRV("Ejercicio",R.raw.ejercicio_web), PalabrasRV("Envidia",R.raw.envidia_web), PalabrasRV("Especial",R.raw.especial_web), PalabrasRV("Facil",R.raw.facil_web), PalabrasRV("Falso",R.raw.falso_web), PalabrasRV("Feo",R.raw.feo_web), PalabrasRV("Fuerte",R.raw.fuerte_web), PalabrasRV("Gordo",R.raw.gordo_web), PalabrasRV("Gratis",R.raw.gratis_web),
        PalabrasRV("Grosero",R.raw.grosero_web), PalabrasRV("Historia",R.raw.historia_web), PalabrasRV("Humilde",R.raw.humilde_web), PalabrasRV("Importante",R.raw.importante_web), PalabrasRV("Jamas",R.raw.jamas_web), PalabrasRV("Junta",R.raw.junta_web), PalabrasRV("Junto",R.raw.junto_web), PalabrasRV("Libre",R.raw.libre_web), PalabrasRV("LSM",R.raw.lsm_web),
        PalabrasRV("Malo",R.raw.malo_web), PalabrasRV("Mas",R.raw.mas_web), PalabrasRV("Mejor",R.raw.mejor_web), PalabrasRV("Miedo",R.raw.miedo_web), PalabrasRV("No",R.raw.no_web), PalabrasRV("Nuevo",R.raw.nuevo_web), PalabrasRV("Nunca",R.raw.nunca_web), PalabrasRV("Paciencia",R.raw.paciencia_web), PalabrasRV("Peor",R.raw.peor_web), PalabrasRV("Pero",R.raw.pero_web),
        PalabrasRV("Presumido",R.raw.presumido_web), PalabrasRV("Rapido/Pronto",R.raw.rapidopronto_web),PalabrasRV("Raro",R.raw.raro_web), PalabrasRV("Secreto",R.raw.secreto_web), PalabrasRV("Senaproipa",R.raw.senaproipa_web), PalabrasRV("Senas",R.raw.senas_web), PalabrasRV("Suerte",R.raw.suerte_web), PalabrasRV("Todo",R.raw.todo_web), PalabrasRV("Travieso",R.raw.travieso_web),
        PalabrasRV("Triste",R.raw.triste_web), PalabrasRV("Verdad",R.raw.verdad_web), PalabrasRV("Adentro",R.raw.adentro_web), PalabrasRV("Alegre/Divertido",R.raw.alegredivertido_web), PalabrasRV("Enojado",R.raw.enojado_web), PalabrasRV("Feliz",R.raw.feliz_web), PalabrasRV("Fuerza",R.raw.fuerza_web), PalabrasRV("Guapo",R.raw.guapo_web), PalabrasRV("Inteligente",R.raw.inteligente_web),
        PalabrasRV("Lejos",R.raw.lejos_web), PalabrasRV("Necio",R.raw.necio_web), PalabrasRV("Ojala",R.raw.ojala_web), PalabrasRV("Pobre",R.raw.pobre_web), PalabrasRV("Sucio",R.raw.sucio_web)),

    mutableListOf(PalabrasRV("0",R.raw.cero), PalabrasRV("1",R.raw.uno),PalabrasRV("2",R.raw.dos),PalabrasRV("3",R.raw.tres),PalabrasRV("4",R.raw.cuatro),PalabrasRV("5",R.raw.cinco), PalabrasRV("6",R.raw.seis), PalabrasRV("7",R.raw.siete), PalabrasRV("8",R.raw.ochenta_web), PalabrasRV("9",R.raw.nueve_web), PalabrasRV("10",R.raw.dies_web),
        PalabrasRV("11",R.raw.once_web), PalabrasRV("12",R.raw.doce_web),PalabrasRV("13",R.raw.trece_web), PalabrasRV("14",R.raw.catorce_web), PalabrasRV("15",R.raw.quince_web), PalabrasRV("16",R.raw.dieciseis_web), PalabrasRV("17",R.raw.diecisiete_web), PalabrasRV("18",R.raw.dieciocho_web), PalabrasRV("19",R.raw.diecinueve_web), PalabrasRV("20",R.raw.veinte_web), PalabrasRV("25",R.raw.veinteycinco_web),
        PalabrasRV("30",R.raw.treinta_web), PalabrasRV("40",R.raw.cuarenta_web),PalabrasRV("50",R.raw.cincuenta_web), PalabrasRV("60",R.raw.sesenta_web), PalabrasRV("70",R.raw.setenta_web), PalabrasRV("80",R.raw.ochenta_web), PalabrasRV("90",R.raw.noventa_web), PalabrasRV("100",R.raw.cien_web),PalabrasRV("200",R.raw.docientos_web), PalabrasRV("300",R.raw.trecientos_web), PalabrasRV("400",R.raw.cuatrocientos_web),
        PalabrasRV("500",R.raw.quinientos_web), PalabrasRV("600",R.raw.seisientos_web), PalabrasRV("700",R.raw.setecientos_web), PalabrasRV("800",R.raw.ochocientos_web), PalabrasRV("1000",R.raw.mil_web), PalabrasRV("1000000",R.raw.millon_web)),

    mutableListOf(PalabrasRV("Conocer",R.raw.conocer_web), PalabrasRV("Entender",R.raw.entenderverbonarrativo_web), PalabrasRV("Gustar",R.raw.gustar_web), PalabrasRV("Haber",R.raw.haber_web), PalabrasRV("No conocer",R.raw.noconocer_web), PalabrasRV("No entender",R.raw.noentender_web), PalabrasRV("No gustar",R.raw.nogustar_web), PalabrasRV("No haber",R.raw.nohaber_web), PalabrasRV("No poder",R.raw.nopoder_web),
        PalabrasRV("No querer",R.raw.noquerer_web), PalabrasRV("No saber",R.raw.nosaber_web), PalabrasRV("No servir",R.raw.noservir_web), PalabrasRV("Poder",R.raw.poderverbonarrativo_web), PalabrasRV("Querer",R.raw.querer_web), PalabrasRV("Saber",R.raw.saber_web), PalabrasRV("Servir",R.raw.servir_web)),

    mutableListOf(PalabrasRV("Foco",R.raw.foco_web), PalabrasRV("Gas",R.raw.gas_web), PalabrasRV("Lavadora",R.raw.lavadora_web), PalabrasRV("Licuadora",R.raw.licuadora_web), PalabrasRV("Llave",R.raw.llave_web), PalabrasRV("Luz",R.raw.luz_web), PalabrasRV("Mesa",R.raw.mesa_web), PalabrasRV("Plancha",R.raw.plancha_web), PalabrasRV("Puerta",R.raw.puerta_web), PalabrasRV("Silla",R.raw.silla_web),
        PalabrasRV("Telefono",R.raw.telefono_web), PalabrasRV("Tenedor",R.raw.tenedor_web), PalabrasRV("Vaso",R.raw.vaso_web), PalabrasRV("Ventana",R.raw.ventana_web), PalabrasRV("Cama",R.raw.cama_web), PalabrasRV("Casa",R.raw.casa_web), PalabrasRV("Cuarto",R.raw.cuarto_web), PalabrasRV("Impresora",R.raw.impresora_web), PalabrasRV("Plato",R.raw.plato_web)),

    mutableListOf(PalabrasRV("Antro",R.raw.antro_web), PalabrasRV("Banco",R.raw.banco_web), PalabrasRV("Calle",R.raw.calle_web), PalabrasRV("Cantina",R.raw.cantina_web), PalabrasRV("Casa", R.raw.casalugar_web), PalabrasRV("Centro",R.raw.centro_web), PalabrasRV("Cine",R.raw.cine_web), PalabrasRV("Ciudad",R.raw.ciudad_web), PalabrasRV("Edificio",R.raw.edificio_web), PalabrasRV("Escuela",R.raw.escuela_web),
        PalabrasRV("Fabrica",R.raw.fabrica_web), PalabrasRV("Feria",R.raw.feria_web), PalabrasRV("Fiesta",R.raw.fiesta_web), PalabrasRV("Hotel",R.raw.hotel_web), PalabrasRV("Iglesia",R.raw.iglesia_web), PalabrasRV("Mercado",R.raw.mercado_web), PalabrasRV("Museo",R.raw.museo_web), PalabrasRV("Restaurante",R.raw.restaurante_web),PalabrasRV("Teatro",R.raw.teatro_web), PalabrasRV("Tienda",R.raw.tienda_web))
)