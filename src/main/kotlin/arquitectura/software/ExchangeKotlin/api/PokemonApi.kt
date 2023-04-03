package arquitectura.software.ExchangeKotlin.api

import arquitectura.software.ExchangeKotlin.bl.PokemonBl
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/api/v1")
class PokemonApi @Autowired constructor(private val pokemonBl: PokemonBl){

    companion object{
        val logger: Logger = LoggerFactory.getLogger(PokemonApi::class.java)
    }

    @GetMapping("/pokemon")
    fun getPokemon(@RequestParam name:String): Any{
        logger.info("Pokemon: $name")
        return pokemonBl.catchPokemon(name)

    }




}