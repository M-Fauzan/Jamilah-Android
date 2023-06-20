package id.ac.pnj.fauzan.jamilah.retrofit

import id.ac.pnj.fauzan.jamilah.authentication.CommonResponse
import id.ac.pnj.fauzan.jamilah.authentication.SuccessfulLoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/consumer/login")
    @Headers("Content-Type:application/json")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): SuccessfulLoginResponse

    @POST("api/v1/consumer/register")
    @Headers("Content-Type:application/json")
    suspend fun register(
        @Field("name") name: String,
        @Field("handphone_number") handphoneNumber: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): CommonResponse


}