package arquitectura.software.ExchangeKotlin.Adapter

import arquitectura.software.ExchangeKotlin.dto.PokemonDto
import com.fasterxml.jackson.databind.ObjectMapper
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import java.lang.RuntimeException
import com.squareup.okhttp.Response
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class PokeApi () {
    fun getPokemonInfo(name:String): PokemonDto {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
                .url("https://pokeapi.co/api/v2/pokemon/$name")
                .build()
        val response = client.newCall(request).execute()
        if(response.code() != 200){
            throw RuntimeException("Ocurrio un error con el servicio de PokeAPI")
        }
        return parseResponse(response, PokemonDto::class.java)
    }

    private fun <T> parseResponse(response: Response, valueType: Class<T>): T {
        return try {
            val body = response.body()!!.string()
            val mapper = ObjectMapper()
            mapper.readValue(body, valueType)
        } catch (e: IOException) {
            throw RuntimeException("Ocurrio un error en el Mapper: " + e.message)
        }
    }
}