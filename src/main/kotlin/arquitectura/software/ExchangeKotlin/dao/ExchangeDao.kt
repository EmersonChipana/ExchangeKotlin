package arquitectura.software.ExchangeKotlin.dao

import java.math.BigDecimal
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GeneratedValue

@Entity
@Table(name = "exchange")
class ExchangeDao(
    var ExchangeFrom: String,
    var ExchangeTo: String,
    var amount: BigDecimal,
    var result: BigDecimal,
    var date: String,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
){
    constructor() : this("", "", BigDecimal.ZERO, BigDecimal.ZERO, "")
}