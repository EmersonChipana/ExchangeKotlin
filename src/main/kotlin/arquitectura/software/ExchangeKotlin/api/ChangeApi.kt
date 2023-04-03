package arquitectura.software.ExchangeKotlin.api

import arquitectura.software.ExchangeKotlin.bl.ChangeBl
import arquitectura.software.ExchangeKotlin.dto.RequestDto
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigDecimal


@RestController
@RequestMapping("/api/v1/exchange")
class ChangeApi @Autowired constructor(private val changeBl: ChangeBl) {

    companion object{
        val logger: Logger = LoggerFactory.getLogger(ChangeApi::class.java)
    }
    @GetMapping("/get")
    fun getExchange(@RequestParam from: String, @RequestParam to: String, @RequestParam amount: BigDecimal): RequestDto {
        logger.info("Se recibio la peticion de cambio de moneda")
        return changeBl.getExchange(from, to, amount)
    }

    @GetMapping("/getall")
    fun getAll(@RequestParam page: Int, @RequestParam size: Int): ResponseEntity<Any>{
        logger.info("Se recibio la peticion de listado")
        return changeBl.getExchangeHistory(page, size)
    }
}