package com.example.dvdrental.kotlin.controller

import com.example.dvdrental.kotlin.model.Customer
import com.example.dvdrental.kotlin.repository.CustomerRepository
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate
import java.util.*


@WebMvcTest
class CustomerControllerTest(@Autowired val mockMvc: MockMvc) {
    private val  date = java.sql.Date.valueOf(LocalDate.parse("2018-12-31"))
    private val customer = Customer(1L, 1L, "John", "Doe", "John.Doe@gmail.com", 1L, true,
             date ,date, 1L)

    private val customers = listOf(customer);

    @MockkBean
    lateinit var customerRepository: CustomerRepository

    @Test
    fun getCustomersReturnCustomer() {
        every { customerRepository.findAll() } returns customers;
        val result = mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk).andReturn()
        val responseCustomers: List<Customer?>? = ObjectMapper().readValue(result.response.contentAsString, object : TypeReference<List<Customer?>?>() {})
        assertThat(customers == responseCustomers )
    }
}