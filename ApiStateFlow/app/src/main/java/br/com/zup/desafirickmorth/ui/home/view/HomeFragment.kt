package br.com.zup.desafirickmorth.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.desafirickmorth.R
import br.com.zup.desafirickmorth.constants.PERSONAGENS
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.databinding.FragmentHomeBinding
import br.com.zup.desafirickmorth.ui.home.viewmodel.PersonViewModel
import br.com.zup.desafirickmorth.ui.home.viewstate.PersonStateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val personAdapter by lazy {
        HomeAdapter(arrayListOf(), this::clickPersonDetall)
    }

    private val personViewModel by viewModel<PersonViewModel>()

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
        personViewModel.getAllPeson()
    }

    private fun init() = lifecycleScope.launch {
        personViewModel.personResponse.collect {
            when (it) {
                is PersonStateFlow.Loading -> showLoading()
                is PersonStateFlow.Success -> showPersons(it.persons)
                is PersonStateFlow.Error -> showError(it.message)
            }
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.rvListPerson.visibility = View.GONE
    }

    private fun showPersons(persons: List<PersonResult>) {
        personAdapter.updatePerson(persons as MutableList<PersonResult>)
        binding.rvListPerson.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }

    private fun showError(errorMessage: String) {
        binding.rvListPerson.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
        binding.tvErrorMsg.visibility = View.VISIBLE
        binding.tvErrorMsg.text = errorMessage
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
