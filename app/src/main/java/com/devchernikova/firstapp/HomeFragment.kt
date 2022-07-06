package com.devchernikova.firstapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.devchernikova.firstapp.databinding.FragmentHomeBinding
import java.util.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    val filmsDataBase = listOf(
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
        Film(
            R.drawable.poster3,
            "Discovery",
            "Ten years before Kirk, Spock, and the Enterprise, the USS Discovery discovers new worlds and lifeforms as one Starfleet officer learns to understand all things alien."
        ),
        Film(
            R.drawable.poster4,
            "Halo",
            "Ten years before Kirk, Spock, and the Enterprise, the USS Discovery discovers new worlds and lifeforms as one Starfleet officer learns to understand all things alien."
        ),
        Film(
            R.drawable.poster5,
            "Reacher",
            "Jack Reacher was arrested for murder and now the police need his help. Based on the books by Lee Child."
        ),
        Film(
            R.drawable.poster6,
            "Jack Ryan",
            "Up-and-coming CIA analyst Jack Ryan is thrust into a dangerous field assignment as he uncovers a pattern in terrorist communication that launches him into the center of a dangerous gambit."
        ),
        Film(
            R.drawable.poster7,
            "The wheel of time",
            "Set in a high fantasy world where magic exists, but only some can access it, a woman named Moiraine crosses paths with five young men and women. This sparks a dangerous, world-spanning journey. Based on the book series by Robert Jordan."
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        var fragmentHomeBinding = binding
        AnimationHelper.performFragmentCircularRevealAnimation(binding.homeFragmentRoot, requireActivity(), 1)

        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
        }

        //Подключаем слушателя изменений введенного текста в поиска
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = filmsDataBase.filter {
                    //Чтобы все работало правильно, нужно и запроси и имя фильма приводить к нижнему регистру
                    it.title.toLowerCase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                filmsAdapter.addItems(result)
                return true
            }
        })

            binding.mainRecycler.apply {
                filmsAdapter =
                    FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                        override fun click(film: Film) =
                            (requireActivity() as MainActivity).launchDetailsFragment(film)
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
            filmsAdapter.addItems(filmsDataBase)
        }

    }