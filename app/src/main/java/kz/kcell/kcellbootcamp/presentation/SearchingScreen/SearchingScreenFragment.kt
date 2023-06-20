package kz.kcell.kcellbootcamp.presentation.SearchingScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kz.kcell.kcellbootcamp.R
import kz.kcell.kcellbootcamp.databinding.FragmentMoviesBinding
import kz.kcell.kcellbootcamp.databinding.FragmentSearchingScreenBinding
import kz.kcell.kcellbootcamp.presentation.moviesList.MoviesViewModel
import kz.kcell.kcellbootcamp.utils.Resource
import kz.kcell.kcellbootcamp.utils.toast


class SearchingScreenFragment : Fragment() {

    private lateinit var binding: FragmentSearchingScreenBinding
    private val viewModel by viewModels<SearchingScreenViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchingScreenBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root

        setupOberve()
    }
    fun setupOberve() {
        viewModel.movies.observe(viewLifecycleOwner) {

                if(it.status == Resource.Status.SUCCESS){
                    
                }
        }
    }


}