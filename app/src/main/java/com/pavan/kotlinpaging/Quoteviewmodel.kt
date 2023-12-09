package com.pavan.kotlinpaging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.pavan.kotlinpaging.repositary.Quoterepositary
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Quoteviewmodel @Inject constructor(val quoterepositary: Quoterepositary): ViewModel() {

    val list = quoterepositary.getquotes().cachedIn(viewModelScope)
}