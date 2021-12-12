package com.eslirodrigues.foodpics.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eslirodrigues.foodpics.data.model.Food
import com.eslirodrigues.foodpics.data.retrofit.FoodApi
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FoodSource @Inject constructor(private val foodApi: FoodApi) : PagingSource<Int, Food>() {

    override fun getRefreshKey(state: PagingState<Int, Food>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Food> {
        return try {
            val nextPage = params.key ?: 1
            val foods = foodApi.getAllBurgers()
            LoadResult.Page(
                data = listOf(foods),
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (foods.image.isEmpty()) null else nextPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}