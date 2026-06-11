package com.adzinka.subtracker.core.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.adzinka.subtracker.R
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryCloud
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryEducation
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryFitness
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryGaming
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryMusic
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryNews
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryOther
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryProductivity
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryStreaming
import com.adzinka.subtracker.core.ui.theme.AppColors.HeroCloud
import com.adzinka.subtracker.core.ui.theme.AppColors.HeroFitness
import com.adzinka.subtracker.core.ui.theme.AppColors.HeroMusic
import com.adzinka.subtracker.core.ui.theme.AppColors.HeroProductivity
import com.adzinka.subtracker.core.ui.theme.AppColors.HeroStreaming
import com.adzinka.subtracker.model.Category

val Category.color: Color
    get() = when (this) {
        Category.STREAMING -> CategoryStreaming
        Category.MUSIC -> CategoryMusic
        Category.FITNESS -> CategoryFitness
        Category.PRODUCTIVITY -> CategoryProductivity
        Category.GAMING -> CategoryGaming
        Category.CLOUD -> CategoryCloud
        Category.NEWS -> CategoryNews
        Category.EDUCATION -> CategoryEducation
        Category.OTHER -> CategoryOther
    }

val Category.heroColor: Color
    get() = when (this) {
        Category.STREAMING -> HeroStreaming
        Category.MUSIC -> HeroMusic
        Category.FITNESS -> HeroFitness
        Category.CLOUD -> HeroCloud
        else -> HeroProductivity
    }

@get:DrawableRes
val Category.iconRes: Int
    get() = when (this) {
        Category.STREAMING -> R.drawable.ic_tv
        Category.MUSIC -> R.drawable.ic_music
        Category.FITNESS -> R.drawable.ic_dumbbell
        Category.PRODUCTIVITY -> R.drawable.ic_briefcase
        Category.GAMING -> R.drawable.ic_gamepad_2
        Category.CLOUD -> R.drawable.ic_cloud
        Category.NEWS -> R.drawable.ic_newspaper
        Category.EDUCATION -> R.drawable.ic_graduation
        Category.OTHER -> R.drawable.ic_tag
    }