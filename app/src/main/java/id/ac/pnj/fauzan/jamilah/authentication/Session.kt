package id.ac.pnj.fauzan.jamilah.authentication

data class Session(
    val id: Int,
    val name: String? = null,
    val token: String? = null
)
