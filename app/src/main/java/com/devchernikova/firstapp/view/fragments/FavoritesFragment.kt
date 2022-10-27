package com.devchernikova.firstapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devchernikova.firstapp.view.rv_adapters.FilmListRecyclerAdapter
import com.devchernikova.firstapp.MainActivity
import com.devchernikova.firstapp.R
import com.devchernikova.firstapp.view.rv_adapters.TopSpacingItemDecoration
import com.devchernikova.firstapp.databinding.FragmentFavoritesBinding
import com.devchernikova.firstapp.data.entity.Film
import com.devchernikova.firstapp.utils.AnimationHelper


class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private var fragmentFavoritesBinding: FragmentFavoritesBinding? = null
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val binding = FragmentFavoritesBinding.bind(view)
            fragmentFavoritesBinding = binding

            AnimationHelper.performFragmentCircularRevealAnimation(binding.favoritesFragmentRoot, requireActivity(), 2)

    //Получаем список при транзакции фрагмента
        val favoritesList: List<Film> = emptyList()

    binding.favoritesRecycler.apply {
        filmsAdapter =
            FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
        //Присваиваем адаптер
        adapter = filmsAdapter
        //Присвои layoutmanager
        layoutManager = LinearLayoutManager(requireContext())
        //Применяем декоратор для отступов
        val decorator = TopSpacingItemDecoration(8)
        addItemDecoration(decorator)
    }
    //Кладем нашу БД в RV
    filmsAdapter.addItems(favoritesList)
    }

override fun onDestroyView() {
    // Consider not storing the binding instance in a field, if not needed.
    fragmentFavoritesBinding = null
    super.onDestroyView()
}

}

