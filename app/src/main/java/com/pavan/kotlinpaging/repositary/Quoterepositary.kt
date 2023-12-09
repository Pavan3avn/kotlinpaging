package com.pavan.kotlinpaging.repositary

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.pavan.kotlinpaging.paging.Quotepagingsource
import com.pavan.kotlinpaging.retrofit.QuoteApi
import javax.inject.Inject

class Quoterepositary @Inject constructor(val quoteApi: QuoteApi) {

    fun getquotes()  = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {
            Quotepagingsource(quoteApi)
        }
    ).liveData
}