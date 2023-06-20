package id.ac.pnj.fauzan.jamilah.authentication

import com.google.gson.annotations.SerializedName

data class CommonResponse(
    @SerializedName("error")
    val error: Boolean,

    @SerializedName("message")
    val message: String
)