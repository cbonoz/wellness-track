package com.wellnesstrack.www.wellnesstrack.services

/**

 * Created by kyleareanraines on 3/16/17.
 */

open class AbstractPersistenceService<T> {

    fun retrieve(id: String): T? {
        return null
    }

    fun persist(entity: T): Boolean {
        return true
    }

    fun persistFailed(entity: T): Boolean {
        return true
    }

    fun remove(id: String): Boolean {
        return true
    }

}
