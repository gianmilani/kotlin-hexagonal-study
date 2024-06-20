package br.study.hexagonal.application.ports.`in`

import br.study.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)
}