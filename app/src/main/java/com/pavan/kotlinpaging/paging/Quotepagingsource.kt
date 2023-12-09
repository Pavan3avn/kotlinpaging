package com.pavan.kotlinpaging.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.Retrofit
import com.pavan.kotlinpaging.models.Result
import com.pavan.kotlinpaging.retrofit.QuoteApi

class Quotepagingsource(val quoteApi: QuoteApi): PagingSource<Int,Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        try {
            val position = params.key ?: 1
            val response = quoteApi.getallresults(position)
            return LoadResult.Page(
                data = response.results,
                prevKey = if(position == 1) null else position-1,
                nextKey = if(position == response.totalPages) null else position+1)

        }
        catch (e : Exception){
                return LoadResult.Error(e)
        }
    }
}