package org.jvf.sincara.ui.dashboard

import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    val authState = FirebaseUserLiveData()
}