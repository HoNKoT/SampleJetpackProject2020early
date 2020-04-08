package jp.chau2chaun2.honkot.samplejetpackproject2020.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(count: Int = 0) : ViewModel() {
    /**
     * For set count
     */
    private val mCount = MutableLiveData(0)

    /**
     * For get count
     */
    val count: LiveData<Int> = mCount

    /**
     * Transform count to the message format automatically
     */
    val countMessage: LiveData<String> = Transformations.map(mCount) { count ->
        "count number is $count"
    }

    init {
        mCount.value = count
    }

    fun countUp() {
        val currentCount = mCount.value ?: throw Exception("Invalid _count value")
        mCount.value = currentCount + 1
    }
}
