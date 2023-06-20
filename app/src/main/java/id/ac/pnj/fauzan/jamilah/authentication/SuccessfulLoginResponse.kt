package id.ac.pnj.fauzan.jamilah.authentication

import com.google.gson.annotations.SerializedName

data class SuccessfulLoginResponse(

    @field:SerializedName("error")
	val error: Boolean,

    @field:SerializedName("message")
	val message: String,

	@field:SerializedName("id")
	val id: Int?
)


