package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import jp.chau2chaun2.honkot.samplejetpackproject2020.manager.LegacyManager

@InstallIn(ApplicationComponent::class)
@EntryPoint
interface LegacyModuleEntryPoint {
    fun legacyManager(): LegacyManager
}
