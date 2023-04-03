package arquitectura.software.ExchangeKotlin.Adapter

import arquitectura.software.ExchangeKotlin.dto.PokemonDto

class PokemonAdapter: Pokemon {

    constructor() : super(0, "", "", 0.0, 0.0, "")


    override fun generateCatchRate(): Int {
        val random = kotlin.random.Random.nextInt(50)
        return random;
    }


    fun generatePokemon(pokemonDto: PokemonDto){
        id = pokemonDto.id
        name = pokemonDto.name
        type = pokemonDto.types[0].type.name
        weight = pokemonDto.weight.toDouble()
        height = pokemonDto.height.toDouble()
        image = pokemonDto.sprites.front_default
    }

}
