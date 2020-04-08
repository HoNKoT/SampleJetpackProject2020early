package jp.chau2chaun2.honkot.samplejetpackproject2020.vm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import jp.chau2chaun2.honkot.samplejetpackproject2020.vm.MainViewModel

class MainViewModelFactory(private val count: Int) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(count) as T
    }
}
