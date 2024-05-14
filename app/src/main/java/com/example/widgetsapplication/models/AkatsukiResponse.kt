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
    val jutsu: List<String>? = null,
    val natureType: List<String>? = null,
    val personal: Personal,
    val family: Map<String, String>? = null
)

data class Personal(
    val sex: String,
    val age: Map<String, String>,
    val status: String,
    val height: Map<String, String>? = null,
    val weight: Map<String, String>? = null,
    val clan: String? = null,
    val titles: List<String>? = null
)


