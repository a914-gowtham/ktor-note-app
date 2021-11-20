package com.gowtham.login

import androidx.lifecycle.ViewModel
import com.gowtham.core.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val logger: Logger,
    private val value: String,
    ) : ViewModel() {


    init {
        logger.log("init LoginViewModel $value")
    }
}