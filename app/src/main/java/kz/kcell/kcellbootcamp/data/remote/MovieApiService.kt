package kz.kcell.kcellbootcamp.data.remote

import kz.kcell.kcellbootcamp.data.entities.Movie
import kz.kcell.kcellbootcamp.data.entities.MovieResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieResults>

    @GET("movie/{id}")
    suspend fun getMovie(@Path("id") id: Int, @Query("api_key") apiKey: String): Response<Movie>
}