package jp.chau2chaun2.honkot.samplejetpackproject2020.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.Repo

class MainViewModel @ViewModelInject constructor(
    private val repo: Repo
) : ViewModel() {
    /**
     * For set count
     */
    private val mCount = MutableLiveData(repo.getCount())

    /**
     * For get count
     */
    val count: LiveData<Int> = mCount

    /**
     * Transform count to the message format automatically
     */
    val countMessage: LiveData<String> = Transformations.map(mCount) { count ->
        "singleton view model count number is $count"
    }

    init {
        mCount.value = repo.getCount()
    }

    fun countUp() {
        repo.countUp()
        mCount.value = repo.getCount()
    }
}
