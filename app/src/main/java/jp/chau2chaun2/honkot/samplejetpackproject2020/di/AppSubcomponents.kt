package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.Repo
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.SampleRepo
import jp.chau2chaun2.honkot.samplejetpackproject2020.manager.LegacyManager

@Module
@InstallIn(ApplicationComponent::class)
class AppSubcomponents
