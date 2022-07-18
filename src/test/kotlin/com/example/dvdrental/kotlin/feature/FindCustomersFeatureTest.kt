package com.example.dvdrental.kotlin.feature

import com.example.dvdrental.kotlin.Application
import com.example.dvdrental.kotlin.model.Customer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import java.time.LocalDate

@SpringBootTest(
        classes = arrayOf(Application::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FindCustomersFeatureTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    val customer = Customer(null, 1L, "John", "Doe", "John.Doe@gmail.com", 1L, true,
            java.sql.Date.valueOf(LocalDate.parse("2018-12-31")) ,java.sql.Date.valueOf(LocalDate.parse("2018-12-31")), 1L)

    @Test
    fun whenGetCustomersCalledShouldReturnCustomers() {
        val postResult = restTemplate.postForEntity("/api/customer", customer, Customer::class.java)
        assertNotNull(postResult)
        assertEquals(HttpStatus.OK, postResult?.statusCode)
        val result = restTemplate.getForEntity("/api/customers", List::class.java)
        val customers : List<Customer> = result.body as List<Customer>
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)
        assertThat(customers[0] == postResult.body as Customer )

    }
}
