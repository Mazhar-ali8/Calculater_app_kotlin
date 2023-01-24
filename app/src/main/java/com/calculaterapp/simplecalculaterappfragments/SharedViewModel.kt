package com.calculaterapp.simplecalculaterappfragments

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.calculaterapp.simplecalculaterappfragments.utils.*

class SharedViewModel : ViewModel() {
    var InputNumberTextView: ObservableField<String> = ObservableField<String>()
    var resultTextView: ObservableField<String> = ObservableField<String>()
    init {
        InputNumberTextView.set("0")
        resultTextView.set("0")
    }
}