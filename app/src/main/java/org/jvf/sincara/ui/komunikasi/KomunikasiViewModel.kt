package org.jvf.sincara.ui.angka

import ApiStatus
import KomunikasiApi
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jvf.sincara.model.HasilKomunikasi

class KomunikasiViewModel : ViewModel() {

    private val data = MutableLiveData<List<HasilKomunikasi>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(KomunikasiApi.service.getKomunikasi())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("KomunikasiViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<HasilKomunikasi>> = data

    fun getStatus(): LiveData<ApiStatus> = status

}