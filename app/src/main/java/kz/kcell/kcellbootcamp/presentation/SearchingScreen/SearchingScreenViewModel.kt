package kz.kcell.kcellbootcamp.presentation.SearchingScreen

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kz.kcell.kcellbootcamp.data.repository.MovieRepository
import javax.inject.Inject

@HiltViewModel
class SearchingScreenViewModel @Inject constructor(
        repository: MovieRepository
) : ViewModel() {

    val movies = repository.getMovies()




}