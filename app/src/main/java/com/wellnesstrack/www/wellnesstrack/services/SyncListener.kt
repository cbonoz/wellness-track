package com.wellnesstrack.www.wellnesstrack.services

/**

 * Created by kyleareanraines on 3/4/17.
 */

interface SyncListener<T : SyncResponse> {

    fun onSuccess(response: T)
    fun onFailed(response: T)
}
