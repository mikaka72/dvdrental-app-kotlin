package com.example.dvdrental.kotlin.repository

import com.example.dvdrental.kotlin.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long>{
}