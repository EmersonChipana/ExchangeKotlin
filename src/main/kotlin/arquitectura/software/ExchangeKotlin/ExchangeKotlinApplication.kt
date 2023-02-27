package arquitectura.software.ExchangeKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExchangeKotlinApplication

fun main(args: Array<String>) {
	try{
		runApplication<ExchangeKotlinApplication>(*args)
	} catch (e: Exception) {
		println("Error: ${e.message}")
	}
}
