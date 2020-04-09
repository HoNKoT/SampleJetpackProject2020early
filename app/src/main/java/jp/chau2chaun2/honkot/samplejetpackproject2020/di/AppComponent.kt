package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import jp.chau2chaun2.honkot.samplejetpackproject2020.CustomApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class, // これが必要
    AppModule::class,
    ActivityModule::class,
    FragmentModule::class,
    ViewModelModule::class
])
interface AppComponent : AndroidInjector<CustomApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: CustomApplication): AppComponent
    }
}
