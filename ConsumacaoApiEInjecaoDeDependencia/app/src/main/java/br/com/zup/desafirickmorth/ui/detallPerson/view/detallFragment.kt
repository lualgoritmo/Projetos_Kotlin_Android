package br.com.zup.desafirickmorth.ui.detallPerson.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.zup.desafirickmorth.constants.PERSONAGENS
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.databinding.FragmentDetallBinding
import com.squareup.picasso.Picasso

class detallFragment : Fragment() {
    private lateinit var binding: FragmentDetallBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDetails()
    }

    private fun showDetails() {
        val persons = arguments?.getParcelable<PersonResult>(PERSONAGENS)
        persons?.let {
            (activity as AppCompatActivity).supportActionBar?.title = it.name
            Picasso.get().load(it.image).into(binding.ivImageView)
            binding.ivTxtName.text = "nome: ${it.name}"
            binding.ivTxtStatus.text = "Status: ${it.status}"
            binding.ivTxtSpecie.text = "Especié: ${it.species}"
            binding.ivTxtGender.text = "Gênero: ${it.gender}"
        }
    }
}
