package org.jvf.sincara.ui.profile

import androidx.lifecycle.ViewModel
import org.jvf.sincara.ui.login.FirebaseUserLiveData

class ProfileViewModel : ViewModel() {

    val authState = FirebaseUserLiveData()
}