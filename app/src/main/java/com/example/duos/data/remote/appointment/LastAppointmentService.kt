package com.example.duos.data.remote.appointment

import android.util.Log
import com.example.duos.data.entities.appointment.LastAppointmentListView
import com.example.duos.utils.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LastAppointmentService {
    val TAG = "AppointmentService"
    val retrofit = NetworkModule.getRetrofit()

    fun getAppointmentList(lastAppointmentListView: LastAppointmentListView, userIdx: Int) {
        val lastAppointmentService = retrofit.create(LastAppointmentRetrofitInterface::class.java)
        lastAppointmentService.getAppointmentList(userIdx).enqueue(object : Callback<AppointmentResponse> {
            override fun onResponse(call: Call<AppointmentResponse>, response: Response<AppointmentResponse>) {
                val resp = response.body()!!
                when (resp.code) {
                    1000 -> resp.let {
                        lastAppointmentListView.onGetAppointmentSuccess(it)
                        Log.d(TAG, resp.toString())
                        Log.d(TAG, resp.result.toString())
                    }

                    else -> lastAppointmentListView.onGetAppointmentFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<AppointmentResponse>, t: Throwable) {
                Log.d("$TAG/API-ERROR", t.message.toString())
                lastAppointmentListView.onGetAppointmentFailure(400, "네트워크 오류 발생")


            }
        })
    }

    //TODO :     fun Post?

}