package jp.chau2chaun2.honkot.samplejetpackproject2020.vm

import androidx.lifecycle.ViewModel

class MainViewModel(count: Int = 0) : ViewModel() {
    var count: Int = 0
        private set

    init {
        this.count = count
    }

    fun countUp() = count++
}
