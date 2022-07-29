package com.example.movylistapp.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.movylistapp.databinding.FragmentMovieListBinding
import com.example.movylistapp.domain.model.Movie
import com.example.movylistapp.presentation.adapter.MovieAdapter
import javax.inject.Inject

class MovieListFragment : Fragment() {
    private var _binding: FragmentMovieListBinding? = null
    private val binding
        get() = _binding ?: throw NullPointerException("FragmentMovieListBinding is null")

    private lateinit var viewModel: MovieViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MovieApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter()
        adapter.onItemClickListener = object : MovieAdapter.OnItemClickListener {
            override fun onClick(movie: Movie) {
                launchDetailFragment(movie.id)
            }
        }

        binding.rvMoviesList.adapter = adapter
        viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
        viewModel.movieList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun launchDetailFragment(id: Long) {
        findNavController().navigate(
            MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(
                id
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}