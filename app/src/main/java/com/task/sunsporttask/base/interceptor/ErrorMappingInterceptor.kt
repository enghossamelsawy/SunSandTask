package com.task.sunsporttask.base.interceptor

import com.task.sunsporttask.base.data.RemoteConstants
import com.task.sunsporttask.base.exception.APIException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.SocketTimeoutException


/**
 * Created by Attia Gamea on 16/06/19.
 */
class ErrorMappingInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response: Response
        try {
            response = chain.proceed(request)
        } catch (e: IOException) {
            if (e is SocketTimeoutException) {
                throw APIException(
                    RemoteConstants.TIME_OUT_STATUS_CODE,
                    "Time Out"
                )
            } else {
                throw APIException(
                    RemoteConstants.LOST_CONNECTION_STATUS_CODE,
                    "Connection lost"
                )
            }
        }



        return response
    }


}