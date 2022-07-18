package com.example.dvdrental.kotlin.controller

import com.example.dvdrental.kotlin.model.Customer
import com.example.dvdrental.kotlin.repository.CustomerRepository
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class CustomerController(private val customerRepository: CustomerRepository) {

    @GetMapping("/customers")
    fun getCustomers(): List<Customer>{
        return customerRepository.findAll();
    }

    @PostMapping("/customer")
    fun addCustomer(@Valid @RequestBody customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}