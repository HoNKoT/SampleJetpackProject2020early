package jp.chau2chaun2.honkot.samplejetpackproject2020.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.chau2chaun2.honkot.samplejetpackproject2020.model.SampleBindingData
import kotlinx.coroutines.launch

class GroupieListViewModel @ViewModelInject constructor() : ViewModel() {

    private val _listItems = MutableLiveData<List<SampleBindingData>>()
    val listItems: LiveData<List<SampleBindingData>> = _listItems

    fun initialize() {
        viewModelScope.launch {
            _listItems.value = (1..500).map { SampleBindingData(it.toString()) }.toList()
        }
    }
}
