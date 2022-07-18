package com.example.dvdrental.kotlin.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Customer (@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val customer_id: Long?, val store_id: Long?,  @get: NotBlank val first_name: String,  @get: NotBlank val last_name: String,
                     @get: NotBlank val email: String, val address_id: Long?, val activebool: Boolean?,
                     val create_date: Date, val last_update: Date, val active: Long?)