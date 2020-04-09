package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import jp.chau2chaun2.honkot.samplejetpackproject2020.CustomApplication
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel
import javax.inject.Singleton

@Module
interface ViewModelModule {

    @Binds
    fun context(app: CustomApplication): Context

    @Binds
    fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(viewModel: MainViewModel): ViewModel
}
