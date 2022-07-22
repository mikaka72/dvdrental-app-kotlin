package com.example.dvdrental.kotlin.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Customer (@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                     @JsonProperty("id") val customer_id: Long?, @JsonProperty("storeId") val store_id: Long?,
                     @get: NotBlank @JsonProperty("firstName") val first_name: String, @get: NotBlank  @JsonProperty("lastName") val last_name: String,
                     @get: NotBlank val email: String, @JsonProperty("addressId") val address_id: Long?, val activebool: Boolean?,
                     @JsonProperty("createDate") val create_date: Date, @JsonProperty("lastUpdate") val last_update: Date, val active: Long?)