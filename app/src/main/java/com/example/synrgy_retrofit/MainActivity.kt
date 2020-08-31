package com.example.synrgy_retrofit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synrgy_retrofit.network.ApiClient
import com.example.synrgy_retrofit.pojo.GetPersonsResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please Wait...")
    }

    override fun onResume() {
        super.onResume()
        getPerson()
    }

    fun getPerson(){
        progressDialog.show()
        ApiClient.apiService.getAllPersons().enqueue(object : Callback<GetPersonsResponse> {
            override fun onResponse(
                call: Call<GetPersonsResponse>,
                response: Response<GetPersonsResponse>
            ) {
                response.body()?.result?.let {
                    val  adapter = PersonAdapter(it)
                    rvContainer.adapter = adapter
                    rvContainer.layoutManager =
                        LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                }

                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<GetPersonsResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error ${t.localizedMessage}", Toast.LENGTH_LONG).show()
                progressDialog.dismiss()
            }

        })
    }
}