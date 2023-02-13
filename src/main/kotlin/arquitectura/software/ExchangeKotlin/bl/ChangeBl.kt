package arquitectura.software.ExchangeKotlin.bl

import java.math.BigDecimal
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.io.IOException

import arquitectura.software.ExchangeKotlin.dto.ErrorDto
import arquitectura.software.ExchangeKotlin.dto.RequestDto



import com.fasterxml.jackson.databind.ObjectMapper
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response

@Service
class ChangeBl {

    private val logger: Logger = LoggerFactory.getLogger(ChangeBl::class.java)

    @Value("\${api.url}")
    private lateinit var apiUrl: String

    @Value("\${api.key}")
    private lateinit var apiKey: String

    fun getExchange(from: String, to: String, amount: BigDecimal): ResponseEntity<String> {
        validateValues(from, to, amount)
        val response = requestApi(from, to, amount)
        val requestDto = parseResponse(response, RequestDto::class.java)
        return ResponseEntity.ok(requestDto.toString())
    }

    private fun validateValues(from: String, to: String, amount: BigDecimal) {
        if (from.isNullOrEmpty()) {
            logger.error("Ocurrio un error: El parametro from es requerido")
            throw IllegalArgumentException("El parametro from es requerido")
        }
        if (to.isNullOrEmpty()) {
            logger.error("Ocurrio un error: El parametro to es requerido")
            throw IllegalArgumentException("El parametro to es requerido")
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Ocurrio un error: El monto debe ser mayor a 0")
            throw IllegalArgumentException("El monto debe ser mayor a 0")
        }
    }

    fun requestApi(from: String, to: String, amount: BigDecimal): Response {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("$apiUrl?to=$to&from=$from&amount=$amount")
            .addHeader("apikey", apiKey)
            .build()
        return try {
            val response = client.newCall(request).execute()
            if (response.code() != 200) {
                val error = parseResponse(response, ErrorDto::class.java)
                logger.error("Ocurrio un error aqui: " + error.error?.message)
                throw RuntimeException("Ocurrio un error: " + error.error?.message)
            }
            response
        } catch (e: IOException) {
            logger.error("Ocurrio un error: " + e.message)
            throw RuntimeException("Ocurrio un error: " + e.message)
        }
    }

    private fun <T> parseResponse(response: Response, valueType: Class<T>): T {
        return try {
            val body = response.body()!!.string()
            val mapper = ObjectMapper()
            mapper.readValue(body, valueType)
        } catch (e: IOException) {
            logger.error("Ocurrio un error: " + e.message)
            throw RuntimeException("Ocurrio un error: " + e.message)
        }
    }
}