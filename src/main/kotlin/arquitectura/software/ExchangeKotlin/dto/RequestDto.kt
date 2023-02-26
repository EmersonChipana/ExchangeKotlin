package arquitectura.software.ExchangeKotlin.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal
import java.util.Date


@JsonIgnoreProperties(ignoreUnknown = true)
data class RequestDto(val date: Date, val query: QueryDto, val result: BigDecimal,  val success: Boolean){
    constructor() : this(
        Date(),
        QueryDto("", "", BigDecimal(0)),
        BigDecimal.ZERO,
        false
    )

    override fun toString(): String {
        return "RequestDto{date=$date query=$query, result=$result, success=$success)"
    }
}