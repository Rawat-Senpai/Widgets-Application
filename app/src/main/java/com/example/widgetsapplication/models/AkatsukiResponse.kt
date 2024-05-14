package com.example.widgetsapplication.models

data class AkatsukiResponse(
    val akatsuki: ArrayList<AkatsukiMember>,
    val currentPage: Int,
    val pageSize: Int,
    val totalMembers: Int
)

data class AkatsukiMember(
    val id: Int,
    val name: String,
    val images: List<String>,
    val debut: Debut,
    val jutsu: List<String>? = null,
    val natureType: List<String>? = null,
    val personal: Personal,
    val tools: List<String>? = null,
//    val voiceActors: VoiceActors? = null,
    val family: Map<String, String>? = null
)

data class Debut(
    val manga: String? = null,
    val anime: String? = null,
    val novel: String? = null,
    val movie: String? = null,
    val game: String? = null,
    val ova: String? = null,
    val appearsIn: String? = null
)

data class Personal(
    val sex: String,
    val species: String? = null,
    val age: Map<String, String>,
    val status: String,
//    val affiliation: List<String>,
    val height: Map<String, String>? = null,
    val weight: Map<String, String>? = null,
    val bloodType: String? = null,
//    val kekkeiGenkai: ArrayList<String>? = null,
//    val classification: List<String>? = null,
    val occupation: String? = null,
    val team: List<String>? = null,
    val partner: List<String>? = null,
    val clan: String? = null,
    val titles: List<String>? = null
)

data class VoiceActors(
    val japanese: List<String>,
    val english: List<String>
)
