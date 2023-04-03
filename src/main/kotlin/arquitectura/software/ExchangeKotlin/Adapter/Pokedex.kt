package arquitectura.software.ExchangeKotlin.Adapter

import arquitectura.software.ExchangeKotlin.dao.PokemonDao
import arquitectura.software.ExchangeKotlin.dao.repository.PokemonRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Date

@Service
class Pokedex @Autowired constructor(private val pokemonRepository: PokemonRepository){

    companion object{
        private val logger: Logger = LoggerFactory.getLogger(Pokedex::class.java)
    }

    fun register(pokemon: Pokemon){
        val newPokemon = PokemonDao()
        if(wasCatched(pokemon)){
            newPokemon.Name = pokemon.name
            newPokemon.Num = pokemon.id
            newPokemon.Poke_Type = pokemon.type
            newPokemon.Weight = pokemon.weight
            newPokemon.Height = pokemon.height
            newPokemon.image = pokemon.image
            newPokemon.date = Date().toString()
            pokemonRepository.save(newPokemon)
            logger.info("Pokemon registrado")
        }
    }

    fun wasCatched(pokemon: Pokemon): Boolean {
        val random = kotlin.random.Random.nextInt(101)
        if (random >= pokemon.generateCatchRate()) {
            logger.info("${pokemon.name} ha sido atrapado!!!")
            return true
        } else {
            logger.info("${pokemon.name} ha escapado...")
            return false
        }
    }

}