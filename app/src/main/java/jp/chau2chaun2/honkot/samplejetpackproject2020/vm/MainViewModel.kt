package jp.chau2chaun2.honkot.samplejetpackproject2020.vm

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var count: Int = 0
        private set

    fun countUp() = count++
}
