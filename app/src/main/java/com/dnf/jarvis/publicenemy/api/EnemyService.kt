package com.dnf.jarvis.publicenemy.api

import org.w3c.dom.Entity
import retrofit2.http.GET
import rx.Observable

interface EnemyService {

    @GET("/home")
    fun getHomeData():Observable<Entity>
}