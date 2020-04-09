package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.chau2chaun2.honkot.samplejetpackproject2020.ui.main.*

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFirstFragment(): FirstFragment

    @ContributesAndroidInjector
    abstract fun contributeSecondFragment(): SecondFragment

    @ContributesAndroidInjector
    abstract fun contributeThirdFragment(): ThirdFragment

    @ContributesAndroidInjector
    abstract fun contributeForthFragment(): ForthFragment

    @ContributesAndroidInjector
    abstract fun contributeFifthFragment(): FifthFragment
}
