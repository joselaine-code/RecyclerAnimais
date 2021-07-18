package br.com.joselaine.recycleranimais.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.joselaine.recycleranimais.databinding.AnimalItem2Binding
import br.com.joselaine.recycleranimais.databinding.AnimalItemBinding

class AnimalAdapter(
    private val listAnimais: List<Animal>,
    private val onClickListener: (animal: Animal) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class AnimalViewHolder(private val binding: AnimalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            animal: Animal,
            onClickListener: (animal: Animal) -> Unit
        ) {
            with(binding) {
                tvNome.text = animal.nome
                ivAnimal.setImageResource(animal.foto)
                binding.cardView.setOnClickListener {
                    onClickListener(animal)
                }
            }
        }

    }

    inner class AnimalViewHolder2(private val binding: AnimalItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            animal: Animal,
            onClickListener: (animal: Animal) -> Unit
        ) {
            with(binding) {
                tvNome.text = animal.nome
                ivAnimal.setImageResource(animal.foto)
                binding.cardView.setOnClickListener {
                    onClickListener(animal)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_DEFAULT) {
            val binding = AnimalItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            AnimalViewHolder(binding)
        } else {
            val binding = AnimalItem2Binding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            AnimalViewHolder2(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            VIEW_TYPE_BLACK
        } else {
            VIEW_TYPE_DEFAULT
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AnimalViewHolder) {
            holder.bind(listAnimais[position], onClickListener)
        } else if (holder is AnimalViewHolder2) {
            holder.bind(listAnimais[position], onClickListener)
        }
    }

    override fun getItemCount() = listAnimais.size

    companion object {
        const val VIEW_TYPE_DEFAULT = 1
        const val VIEW_TYPE_BLACK = 2
    }
}