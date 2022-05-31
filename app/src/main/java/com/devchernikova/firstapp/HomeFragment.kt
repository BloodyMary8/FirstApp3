package com.devchernikova.firstapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devchernikova.firstapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    val filmsDataBase = listOf(
        Film(
            "Bosch Legacy",
            R.drawable.poster1,
            "An L.A.P.D. homicide detective works to solve the murder of a thirteen-year-old boy while standing trial in federal court for the murder of a serial killer."
        ),
        Film(
            "Picard",
            R.drawable.poster2,
            "Follow-up series to Звездный путь: Следующее поколение (1987) and Звездный путь: Возмездие (2002) that centers on Jean-Luc Picard in the next chapter of his life."
        ),
        Film(
            "Discovery",
            R.drawable.poster3,
            "Ten years before Kirk, Spock, and the Enterprise, the USS Discovery discovers new worlds and lifeforms as one Starfleet officer learns to understand all things alien."
        ),
        Film(
            "Halo",
            R.drawable.poster4,
            "Ten years before Kirk, Spock, and the Enterprise, the USS Discovery discovers new worlds and lifeforms as one Starfleet officer learns to understand all things alien."
        ),
        Film(
            "Reacher",
            R.drawable.poster5,
            "Jack Reacher was arrested for murder and now the police need his help. Based on the books by Lee Child."
        ),
        Film(
            "Jack Ryan",
            R.drawable.poster6,
            "Up-and-coming CIA analyst Jack Ryan is thrust into a dangerous field assignment as he uncovers a pattern in terrorist communication that launches him into the center of a dangerous gambit."
        ),
        Film(
            "The wheel of time",
            R.drawable.poster7,
            "Set in a high fantasy world where magic exists, but only some can access it, a woman named Moiraine crosses paths with five young men and women. This sparks a dangerous, world-spanning journey. Based on the book series by Robert Jordan."
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    private lateinit var binding: FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.mainRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
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
        filmsAdapter.addItems(filmsDataBase)
    }
}