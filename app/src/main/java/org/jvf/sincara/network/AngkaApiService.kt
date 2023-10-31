import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.jvf.sincara.model.HasilAngka
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://raw.githubusercontent.com/fdhandoyo/Sincara/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AngkaApiService {
    @GET("angkaAPI.json")
    suspend fun getAngka(): List<HasilAngka>
}

object AngkaApi {
    val service: AngkaApiService by lazy {
        retrofit.create(AngkaApiService::class.java)
    }

    fun getInfoUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED}

