package com.example.dvdrental.kotlin

import com.example.dvdrental.kotlin.model.Customer
import com.example.dvdrental.kotlin.repository.CustomerRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.time.LocalDate

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Test
    fun whenFindAllThenReturnCustomer(){
        val  date = java.sql.Date.valueOf(LocalDate.parse("2018-12-31"))
        val customer = Customer(null, 1L, "John", "Doe", "John.Doe@gmail.com", 1L, true,
                date ,date, 1L)
        val customers = listOf(customer)
        entityManager.persist(customer)
        entityManager.flush()

        assertThat(customers == customerRepository.findAll())
    }
}