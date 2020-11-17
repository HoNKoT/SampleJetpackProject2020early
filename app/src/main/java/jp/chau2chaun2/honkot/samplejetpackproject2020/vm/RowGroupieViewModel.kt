package jp.chau2chaun2.honkot.samplejetpackproject2020.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.scopes.ViewScoped
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.Repo
import jp.chau2chaun2.honkot.samplejetpackproject2020.di.RowViewModelEntryPoint
import jp.chau2chaun2.honkot.samplejetpackproject2020.model.SampleBindingData
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewScoped
class RowGroupieViewModel(entryPoint: RowViewModelEntryPoint) : ViewModel() {
    private val _headText = MutableLiveData("")
    val headText: LiveData<String> = _headText
    private val _tailText = MutableLiveData("")
    val tailText: LiveData<String> = _tailText

    @Inject
    lateinit var repo: Repo

    init { entryPoint.inject(this) }

    fun setData(data: SampleBindingData) {
        viewModelScope.launch {
            _headText.value = data.displayData
            _tailText.value = repo.getCount().toString() + " / @" + Integer.toHexString(this.hashCode())
        }
    }
}
