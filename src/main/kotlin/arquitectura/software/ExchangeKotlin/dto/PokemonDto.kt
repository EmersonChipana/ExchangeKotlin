package arquitectura.software.ExchangeKotlin.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class PokemonDto(
        val id: Int,
        val name: String,
        val types: List<Types>,
        val weight: Int,
        val height: Int,
        val sprites: Sprites,
){
    constructor() : this(
        0,
        "",
        listOf(),
        0,
        0,
        Sprites("")
    )
}
data class Types(
        val slot: Int,
        val type: Type
){
    constructor() : this(
        0,
        Type()
    )
}

data class Type(
        val name: String,
        val url: String
){
    constructor() : this(
        "",
        ""
    )
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class Sprites(
        val front_default: String
){
    constructor() : this(
        ""
    )
}
