package br.com.zup.desafirickmorth.ui.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.desafirickmorth.data.model.PersonResult
import br.com.zup.desafirickmorth.databinding.PersonItemBinding
import com.squareup.picasso.Picasso

class HomeAdapter(
    private var listPerson: MutableList<PersonResult>,
    private var clickDetallPerson: (person: PersonResult) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PersonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = listPerson[position]
        holder.displayCharacterInformation(person)
        holder.itemView.setOnClickListener {
            clickDetallPerson(person)
        }
    }

    override fun getItemCount() = listPerson.size

    class ViewHolder(val binding: PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun displayCharacterInformation(person: PersonResult) {
            Picasso.get().load(person.image).into(binding.personImage)
            binding.ivPersonName.text = person.name
        }
    }

    fun updatePerson(newListPersons: MutableList<PersonResult>) {
        listPerson = newListPersons
        notifyDataSetChanged()
    }
}
