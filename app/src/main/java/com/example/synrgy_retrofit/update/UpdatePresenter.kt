package com.example.synrgy_retrofit.update

import com.example.synrgy_retrofit.network.ApiClient
import com.example.synrgy_retrofit.pojo.GetPersonsResponse
import com.example.synrgy_retrofit.pojo.PutPersonBody
import com.example.synrgy_retrofit.pojo.PutPersonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePresenter (val listener: Listener){
    interface Listener{
        fun showEditSuccess(msg: String)
        fun showEditFailed(msg: String)
    }

    fun updatePerson(result: GetPersonsResponse.Result){
        val obj = PutPersonBody(result.firstName, result.lastName)
        ApiClient.apiService.updatePerson(result.iD.toString(), obj).enqueue(object : Callback<PutPersonResponse> {
            override fun onResponse(
                call: Call<PutPersonResponse>,
                response: Response<PutPersonResponse>
            ) {
                listener.showEditSuccess("Suksess mengubah data person")
            }

            override fun onFailure(call: Call<PutPersonResponse>, t: Throwable) {
                listener.showEditFailed("Error : $t")
            }

        })
    }
}