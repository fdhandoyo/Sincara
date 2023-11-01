package org.jvf.sincara.ui.alphabet

import AlphabetApi
import ApiStatus
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jvf.sincara.model.HasilAlphabet
import org.jvf.sincara.model.HasilAngka

class AlphabetViewModel : ViewModel() {

    private val data = MutableLiveData<List<HasilAlphabet>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(AlphabetApi.service.getAlphabet())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("AlphabetViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<HasilAlphabet>> = data

    fun getStatus(): LiveData<ApiStatus> = status

}