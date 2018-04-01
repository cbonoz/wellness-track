package com.wellnesstrack.www.wellnesstrack.services

import api.ResponseRep

/**

 * Created by kyleareanraines on 3/4/17.
 */

class SyncResponse private constructor(val isSuccess: Boolean, val response: ResponseRep) {
    companion object {

        fun success(response: ResponseRep): SyncResponse {
            return SyncResponse(true, response)
        }

        fun failed(response: ResponseRep): SyncResponse {
            return SyncResponse(false, response)
        }
    }
}
