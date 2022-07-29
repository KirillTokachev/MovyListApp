package com.example.movylistapp.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.movylistapp.databinding.FragmentMovieDetailBinding
import com.squareup.picasso.Picasso
import javax.inject.Inject

class MovieDetailFragment : Fragment() {
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding
        get() = _binding ?: throw NullPointerException("FragmentMovieDetailBinding is null")

    private lateinit var viewModel: MovieViewModel

    private val args by navArgs<MovieDetailFragmentArgs>()

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
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]

        viewModel.getDetailInfoMovie(args.id).observe(viewLifecycleOwner) {
            Picasso.get().load(it.multimedia.src).into(binding.ivMovieImage)
            binding.tvMovieTitle.text = it.displayTitle
            binding.tvDescription.text = it.summaryShort
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}