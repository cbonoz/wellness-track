package com.wellnesstrack.www.wellnesstrack.services

import java.lang.reflect.ParameterizedType
import java.util.ArrayList
import java.util.HashMap

/**

 * Created by kyleareanraines on 3/4/17.
 */

class SyncListenerRegistry {

    private val registryMap = HashMap<Class<out SyncResponse>, Collection<SyncListener<SyncResponse>>>()

    fun register(listener: SyncListener<SyncResponse>): SyncListenerRegistry {
        val t = (javaClass.getGenericSuperclass() as ParameterizedType).actualTypeArguments[0] as ParameterizedType

        var existing: MutableCollection<SyncListener<SyncResponse>>? = registryMap.get(t.rawType) as MutableCollection<SyncListener<SyncResponse>>
        if (existing == null) {
            existing = ArrayList<SyncListener<SyncResponse>>()
            registryMap.put(t.rawType as Class<out SyncResponse>, existing)
        }
        existing.add(listener)

        return this
    }

    operator fun get(clz: Class<out SyncResponse>): Collection<SyncListener<SyncResponse>> {
        return registryMap[clz]!!
    }
}
