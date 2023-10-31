package org.jvf.sincara.ui.angka

import AngkaApi
import ApiStatus
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jvf.sincara.model.HasilAngka

class AngkaViewModel : ViewModel() {

    private val data = MutableLiveData<List<HasilAngka>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(AngkaApi.service.getAngka())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("AngkaViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<HasilAngka>> = data

    fun getStatus(): LiveData<ApiStatus> = status

}