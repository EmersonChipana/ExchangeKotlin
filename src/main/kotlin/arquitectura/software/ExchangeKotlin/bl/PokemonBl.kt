package arquitectura.software.ExchangeKotlin.bl

import arquitectura.software.ExchangeKotlin.Adapter.PokeApi
import arquitectura.software.ExchangeKotlin.Adapter.Pokedex
import arquitectura.software.ExchangeKotlin.Adapter.PokemonAdapter
import arquitectura.software.ExchangeKotlin.dto.PokemonDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PokemonBl @Autowired constructor(
        private val pokedex: Pokedex,
        private val pokeApi: PokeApi
){
    fun catchPokemon(name:String): PokemonDto{
        val pokemon = pokeApi.getPokemonInfo(name)
        val pokemonAdapter = PokemonAdapter()
        pokemonAdapter.generatePokemon(pokemon)
        pokedex.register(pokemonAdapter)
        return pokemon
    }
}