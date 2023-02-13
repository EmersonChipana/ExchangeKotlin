package arquitectura.software.ExchangeKotlin.api

import arquitectura.software.ExchangeKotlin.bl.ChangeBl
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import com.squareup.okhttp.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestParam
import java.lang.RuntimeException
import java.math.BigDecimal


@ControllerAdvice
class MyexceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(e.message)
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(e: RuntimeException): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(e.message)
    }
}

@RestController
@RequestMapping("/api/v1/exchange")
class ChangeApi (private val changeBl: ChangeBl) {

    val logger: Logger = LoggerFactory.getLogger(ChangeApi::class.java)

    @GetMapping("/get")
    fun getExchange(@RequestParam from: String, @RequestParam to: String, @RequestParam amount: BigDecimal): ResponseEntity<String> {
        logger.info("Se recibio la peticion de cambio de moneda")
        return changeBl.getExchange(from, to, amount)
    }



}