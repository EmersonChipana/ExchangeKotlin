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
        weight = pokemonDto.weight.toDouble()/10
        height = pokemonDto.height.toDouble()/10
        image = pokemonDto.sprites.front_default
    }

}
