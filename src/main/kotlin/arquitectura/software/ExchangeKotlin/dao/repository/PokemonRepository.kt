package arquitectura.software.ExchangeKotlin.dao.repository

import arquitectura.software.ExchangeKotlin.dao.PokemonDao
import org.springframework.data.jpa.repository.JpaRepository

interface PokemonRepository: JpaRepository<PokemonDao, Long>{
}