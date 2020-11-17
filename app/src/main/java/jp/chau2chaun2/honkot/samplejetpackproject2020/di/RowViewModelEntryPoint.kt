package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewComponent
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.RowGroupieViewModel

@InstallIn(ViewComponent::class)
@EntryPoint
interface RowViewModelEntryPoint {
    fun inject(viewModel: RowGroupieViewModel)
}
