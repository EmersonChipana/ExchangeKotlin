package arquitectura.software.ExchangeKotlin.dao.repository

import arquitectura.software.ExchangeKotlin.dao.ExchangeDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface ExchangeRepository: JpaRepository<ExchangeDao, Long>{
}