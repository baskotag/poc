package com.poc.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ActivityViewModel @Inject internal constructor() : ViewModel() {
    var toolbarTitle: ObservableField<String> = ObservableField()
}