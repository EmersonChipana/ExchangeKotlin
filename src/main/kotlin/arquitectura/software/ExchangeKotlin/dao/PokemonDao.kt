package arquitectura.software.ExchangeKotlin.dao

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Pokemon")
class PokemonDao (
        var Name:String,
        var Num: Int,
        var Poke_Type: String,
        var Weight: Double,
        var Height: Double,
        var image: String,
        var date: String,
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
) {
    constructor(): this("",0,"", 0.0, 0.0, "","")
}