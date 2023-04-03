package arquitectura.software.ExchangeKotlin.Adapter

import arquitectura.software.ExchangeKotlin.dto.Sprites
import arquitectura.software.ExchangeKotlin.dto.Types

open class Pokemon (
        var id: Int,
        var name: String,
        var type: String,
        var weight: Double,
        var height: Double,
        var image: String,
) {

    open fun generateCatchRate(): Int{
        val random = kotlin.random.Random.nextInt(50)
        return random;
    }
}