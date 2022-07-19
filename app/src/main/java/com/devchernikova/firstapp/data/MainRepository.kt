package com.devchernikova.firstapp.data

import com.devchernikova.firstapp.R
import com.devchernikova.firstapp.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film(
            R.drawable.poster1,
            "Bosch Legacy",
            "An L.A.P.D. homicide detective works to solve the murder of a thirteen-year-old boy while standing trial in federal court for the murder of a serial killer.",
            7.7f
        ),
        Film(
            R.drawable.poster2,
            "Picard",
            "Follow-up series to Звездный путь: Следующее поколение (1987) and Звездный путь: Возмездие (2002) that centers on Jean-Luc Picard in the next chapter of his life.",
            1.7f
        ),
        Film(
            R.drawable.poster3,
            "Discovery",
            "Ten years before Kirk, Spock, and the Enterprise, the USS Discovery discovers new worlds and lifeforms as one Starfleet officer learns to understand all things alien.",
            3.7f
        ),
        Film(
            R.drawable.poster4,
            "Halo",
            "Ten years before Kirk, Spock, and the Enterprise, the USS Discovery discovers new worlds and lifeforms as one Starfleet officer learns to understand all things alien.",
            7.4f
        ),
        Film(
            R.drawable.poster5,
            "Reacher",
            "Jack Reacher was arrested for murder and now the police need his help. Based on the books by Lee Child.",
            7.2f
        ),
        Film(
            R.drawable.poster6,
            "Jack Ryan",
            "Up-and-coming CIA analyst Jack Ryan is thrust into a dangerous field assignment as he uncovers a pattern in terrorist communication that launches him into the center of a dangerous gambit.",
            4.7f
        ),
        Film(
            R.drawable.poster7,
            "The wheel of time",
            "Set in a high fantasy world where magic exists, but only some can access it, a woman named Moiraine crosses paths with five young men and women. This sparks a dangerous, world-spanning journey. Based on the book series by Robert Jordan.",
            7.7f
        ),
    )
}