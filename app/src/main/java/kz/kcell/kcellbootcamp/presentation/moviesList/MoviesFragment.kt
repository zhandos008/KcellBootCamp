package kz.kcell.kcellbootcamp.presentation.moviesList

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kz.kcell.kcellbootcamp.R
import kz.kcell.kcellbootcamp.data.entities.Movie
import kz.kcell.kcellbootcamp.databinding.FragmentMoviesBinding
import kz.kcell.kcellbootcamp.utils.Constants.ARG_MOVIE_ID
import kz.kcell.kcellbootcamp.utils.Resource
import kz.kcell.kcellbootcamp.utils.toast

@AndroidEntryPoint
class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private val binding by viewBinding(FragmentMoviesBinding::bind)
    private val viewModel by viewModels<MoviesViewModel>()
    private val adapter by lazy {
        MoviesAdapter(::onClickedMovie)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieRecyclerView.adapter = this@MoviesFragment.adapter
        setupObservers()

    }

    private fun setupObservers() {
        viewModel.content.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) {
                        Log.i("testZha", it.data.toString())
                        adapter.submitList(it.data)
                        val recyclerView = binding.movieRecyclerView
                        recyclerView.adapter = adapter
                        recyclerView.layoutManager = LinearLayoutManager(this@MoviesFragment.requireContext())

                    }
                }

                Resource.Status.ERROR ->
                    it.message?.let { msg -> toast(requireContext(), msg) }

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        }
    }

    private fun onClickedMovie(movie: Movie) {
        findNavController().navigate(
            R.id.action_moviesFragment_to_movieDetailFragment,
            bundleOf(ARG_MOVIE_ID to movie.id)
        )
    }


}