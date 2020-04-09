package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.chau2chaun2.honkot.samplejetpackproject2020.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
