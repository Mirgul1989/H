package com.example.hw_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw_7.databinding.FragmentFirstBinding


class FirstFragment : Fragment(),onItemClick {
    private lateinit var binding: FragmentFirstBinding
    private var arrayList = arrayListOf<Comics>()
    private lateinit var adapterComics: AdapterComics

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)

        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()

        adapterComics = AdapterComics(arrayList, this)
      binding.recycle1.adapter=adapterComics

    }

    private fun loadData() {
        arrayList.add(Comics(R.drawable.img, "Alive", "Rick Sanchez"))
        arrayList.add(Comics(R.drawable.img_1, "Alive", "Morty Smith"))
        arrayList.add(Comics(R.drawable.img_3, "Dead", "Albert Einstein"))
        arrayList.add(Comics(R.drawable.img_2, "Alive", "Jerry Smith"))

    }


    override fun inItemClick(comics: Comics) {

        findNavController().navigate(R.id.secondFragment, bundleOf("key1" to comics.img, "key2" to comics.name, "key3" to comics.status))

    }
}







