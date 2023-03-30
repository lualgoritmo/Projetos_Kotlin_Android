package br.com.zup.desafirickmorth.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.desafirickmorth.R
import br.com.zup.desafirickmorth.constants.PERSONAGENS
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.databinding.FragmentHomeBinding
import br.com.zup.desafirickmorth.ui.home.viewmodel.PersonViewModel
import br.com.zup.desafirickmorth.ui.home.viewstate.PersonViewState
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val personAdapter: HomeAdapter by inject {
        parametersOf(mutableListOf<PersonResult>(),
            this::clickPersonDetall)
    }
    private val personViewModel: PersonViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        showRecyclerView()
        personViewModel.getAllPerson()
    }

    private fun init() = personViewModel.personResponse.observe(viewLifecycleOwner) { result ->
        when (result) {
            is PersonViewState.Loading -> showLoading()
            is PersonViewState.Success -> showPersons(result.persons)
            is PersonViewState.Error -> showError(result.message)
        }
    }

    private fun showLoading() {
        binding.apply { View.VISIBLE }
    }

    private fun showPersons(persons: List<PersonResult>) {
        personAdapter.updatePerson(persons as MutableList<PersonResult>)
    }

    private fun showError(errorMessage: String) {
        binding.apply {
            errorMessage
            View.GONE
        }
    }

    private fun clickPersonDetall(person: PersonResult) {
        val bundle = bundleOf(PERSONAGENS to person)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_homeFragment_to_detallFragment, bundle)
    }

    private fun showRecyclerView() {
        binding.rvListPerson.adapter = personAdapter
        binding.rvListPerson.layoutManager = GridLayoutManager(context, 2)
    }
}
