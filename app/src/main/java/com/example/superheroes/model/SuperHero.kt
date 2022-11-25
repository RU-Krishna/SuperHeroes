package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SuperHero(@StringRes val name: Int,
@StringRes val ability: Int,
@DrawableRes val icon: Int)
