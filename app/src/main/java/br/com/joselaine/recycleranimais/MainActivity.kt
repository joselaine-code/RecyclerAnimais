package br.com.joselaine.recycleranimais

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.joselaine.recycleranimais.databinding.ActivityMainBinding
import br.com.joselaine.recycleranimais.model.Animal
import br.com.joselaine.recycleranimais.model.AnimalAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listAnimais = mutableListOf(
            Animal("Cachorro", R.drawable.cachorro),
            Animal("Gato",R.drawable.gato),
            Animal("Periquito", R.drawable.periquito),
            Animal("Papagaio", R.drawable.papagaio),
            Animal("Macaco", R.drawable.macaco),
            Animal("Cobra Naja", R.drawable.cobranaja),
            Animal("Leão", R.drawable.leao),
        )

        val animalAdapter = AnimalAdapter(listAnimais){
            Toast.makeText(applicationContext, "${it.nome} clicado!", Toast.LENGTH_SHORT).show()
        }
        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.adapter = animalAdapter

    }
}