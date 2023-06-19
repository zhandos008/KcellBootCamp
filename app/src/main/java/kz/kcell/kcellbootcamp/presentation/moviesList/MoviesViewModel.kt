package kz.kcell.kcellbootcamp.presentation.moviesList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.kcell.kcellbootcamp.data.repository.MovieRepository
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    repository: MovieRepository,
    application: Application
) : AndroidViewModel(application) {

    val content = repository.getMovies()
}