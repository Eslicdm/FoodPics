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
            val pizza = Food(name = "pizza", image = foodApi.getAllPizza().image)
            val burger = Food(name = "burger", image = foodApi.getAllBurgers().image)
            val pasta = Food(name = "pasta", image = foodApi.getAllPasta().image)
            val dessert = Food(name = "dessert", image = foodApi.getAllDessert().image)
            LoadResult.Page(
                data = listOf(pizza, burger, pasta, dessert),
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}