package arquitectura.software.ExchangeKotlin.dto

data class ErrorDto(val error: Error ?){
    constructor() : this(null)
}

data class Error(val code: String?, val message: String?){
    constructor() : this(null, null)

    @Override
    override fun toString(): String {
        return "Error(code=$code, message=$message)"
    }

}
