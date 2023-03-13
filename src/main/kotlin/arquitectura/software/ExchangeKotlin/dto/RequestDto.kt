package arquitectura.software.ExchangeKotlin.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
import java.util.Date


@JsonIgnoreProperties(ignoreUnknown = true)
data class RequestDto(val date: String, val query: QueryDto, val result: BigDecimal,  val success: Boolean){
    constructor() : this(
        "",
        QueryDto("", "", BigDecimal(0)),
        BigDecimal.ZERO,
        false
    )

}