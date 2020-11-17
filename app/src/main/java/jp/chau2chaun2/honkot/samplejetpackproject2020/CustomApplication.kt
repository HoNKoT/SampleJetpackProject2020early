package jp.chau2chaun2.honkot.samplejetpackproject2020

import android.app.Application
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp
import jp.chau2chaun2.honkot.samplejetpackproject2020.di.RowViewModelEntryPoint

@HiltAndroidApp
class CustomApplication : Application() {
    val rowViewModelComponent get() = EntryPoints.get(this, RowViewModelEntryPoint::class.java)
}
