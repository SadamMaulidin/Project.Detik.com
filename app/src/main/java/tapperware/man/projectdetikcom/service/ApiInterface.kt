import retrofit2.Call
import retrofit2.http.GET
import tapperware.man.projectdetikcom.model.News

interface ApiInterface {
    @GET("top-headlines?country=id&apiKey=3e781351d6f247e0989721d329849b94")
    fun getNews(): Call<News>
}