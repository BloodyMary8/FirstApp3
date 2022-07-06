package com.devchernikova.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devchernikova.firstapp.databinding.FragmentFavoritesBinding


class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

private lateinit var binding: FragmentFavoritesBinding
private lateinit var filmsAdapter: FilmListRecyclerAdapter

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FragmentFavoritesBinding.bind(view)

    AnimationHelper.performFragmentCircularRevealAnimation(binding.favoritesFragmentRoot, requireActivity(), 2)
    //Получаем список при транзакции фрагмента
    val favoritesList: List<Film> = listOf(
    Film(
        R.drawable.poster1,
        "Bosch Legacy",
        "An L.A.P.D. homicide detective works to solve the murder of a thirteen-year-old boy while standing trial in federal court for the murder of a serial killer."
    ),
    Film(
        R.drawable.poster2,
        "Picard",
        "Follow-up series to Звездный путь: Следующее поколение (1987) and Звездный путь: Возмездие (2002) that centers on Jean-Luc Picard in the next chapter of his life."
    ),
    )

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
}

