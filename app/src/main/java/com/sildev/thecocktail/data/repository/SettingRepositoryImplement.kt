package com.sildev.thecocktail.data.repository

import com.sildev.thecocktail.data.source.SettingDataSource

class SettingRepositoryImplement(private val local: SettingDataSource.Local) : SettingRepository {

    override fun getNightMode(): Boolean = local.getNightMode()

    override fun setNightMode(value: Boolean) = local.setNightMode(value)

    override fun getLanguage(): Boolean = local.getLanguage()

    override fun setLanguage(value: Boolean) = local.setLanguage(value)
}
