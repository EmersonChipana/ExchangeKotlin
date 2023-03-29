package arquitectura.software.ExchangeKotlin.config

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.lang.RuntimeException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import org.springframework.http.HttpStatus

@ControllerAdvice
class ControllerAdvice: ResponseEntityExceptionHandler(){

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<Any>? {
        val body: MutableMap<String, Any?> = LinkedHashMap()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = e.message
        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(e: RuntimeException): ResponseEntity<Any>? {
        val body: MutableMap<String, Any?> = LinkedHashMap()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = e.message
        return ResponseEntity(body, HttpStatus.SERVICE_UNAVAILABLE)
    }

}