package br.study.hexagonal.application.ports.out

import br.study.hexagonal.application.core.domain.Customer

interface InsertCustomerOutPutPort {

    fun insert(customer: Customer)
}