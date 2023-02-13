package arquitectura.software.ExchangeKotlin.dto

import java.math.BigDecimal

data class QueryDto(
    val from: String?,
    val to: String?,
    val amount: BigDecimal?){
    constructor() : this(null, null, null)

    override fun toString(): String {
        return "QueryDto(from=$from, to=$to, amount=$amount)"
    }
}