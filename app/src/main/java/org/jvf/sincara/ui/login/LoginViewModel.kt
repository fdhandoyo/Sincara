package org.jvf.sincara.ui.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val authState = FirebaseUserLiveData()
}