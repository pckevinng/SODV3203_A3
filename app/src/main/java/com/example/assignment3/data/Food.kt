package com.example.assignment3.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.assignment3.R

data class Food(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val description: Int // Change to String for description
)

val foods = listOf(
    Food(R.drawable.day1, R.string.day_name_1, R.string.day_description_1),
    Food(R.drawable.day2, R.string.day_name_2, R.string.day_description_2),
    Food(R.drawable.day3, R.string.day_name_3, R.string.day_description_3),
    Food(R.drawable.day4, R.string.day_name_4, R.string.day_description_4),
    Food(R.drawable.day5, R.string.day_name_5, R.string.day_description_5),
    Food(R.drawable.day6, R.string.day_name_6, R.string.day_description_6),
    Food(R.drawable.day7, R.string.day_name_7, R.string.day_description_7),
    Food(R.drawable.day8, R.string.day_name_8, R.string.day_description_8),
    Food(R.drawable.day9, R.string.day_name_9, R.string.day_description_9),
    Food(R.drawable.day10, R.string.day_name_10, R.string.day_description_10),
    Food(R.drawable.day11, R.string.day_name_11, R.string.day_description_11),
    Food(R.drawable.day12, R.string.day_name_12, R.string.day_description_12),
    Food(R.drawable.day13, R.string.day_name_13, R.string.day_description_13),
    Food(R.drawable.day14, R.string.day_name_14, R.string.day_description_14),
    Food(R.drawable.day15, R.string.day_name_15, R.string.day_description_15),
    Food(R.drawable.day16, R.string.day_name_16, R.string.day_description_16),
    Food(R.drawable.day17, R.string.day_name_17, R.string.day_description_17),
    Food(R.drawable.day18, R.string.day_name_18, R.string.day_description_18),
    Food(R.drawable.day19, R.string.day_name_19, R.string.day_description_19),
    Food(R.drawable.day20, R.string.day_name_20, R.string.day_description_20),
    Food(R.drawable.day21, R.string.day_name_21, R.string.day_description_21),
    Food(R.drawable.day22, R.string.day_name_22, R.string.day_description_22),
    Food(R.drawable.day23, R.string.day_name_23, R.string.day_description_23),
    Food(R.drawable.day24, R.string.day_name_24, R.string.day_description_24),
    Food(R.drawable.day25, R.string.day_name_25, R.string.day_description_25),
    Food(R.drawable.day26, R.string.day_name_26, R.string.day_description_26),
    Food(R.drawable.day27, R.string.day_name_27, R.string.day_description_27),
    Food(R.drawable.day28, R.string.day_name_28, R.string.day_description_28),
    Food(R.drawable.day29, R.string.day_name_29, R.string.day_description_29),
    Food(R.drawable.day30, R.string.day_name_30, R.string.day_description_30)
)

