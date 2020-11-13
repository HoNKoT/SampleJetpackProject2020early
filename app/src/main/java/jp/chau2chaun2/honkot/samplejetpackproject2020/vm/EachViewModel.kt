package jp.chau2chaun2.honkot.samplejetpackproject2020.vm

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.Repo
import jp.chau2chaun2.honkot.samplejetpackproject2020.manager.LegacyManager
import javax.inject.Inject

class EachViewModel @ViewModelInject constructor(
    private val repo: Repo,
    manager: LegacyManager
) : ViewModel() {

    init {
        Log.e("EachViewModel", "### repo=0x${Integer.toHexString(repo.hashCode())}, manager=0x${Integer.toHexString(manager.hashCode())}")
    }

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
        "each view model count number is $count"
    }

    init {
        mCount.value = repo.getCount()
    }

    fun countUp() {
        repo.countUp()
        mCount.value = repo.getCount()
    }
}
