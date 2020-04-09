package jp.chau2chaun2.honkot.samplejetpackproject2020

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jp.chau2chaun2.honkot.samplejetpackproject2020.di.DaggerAppComponent

class CustomApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
