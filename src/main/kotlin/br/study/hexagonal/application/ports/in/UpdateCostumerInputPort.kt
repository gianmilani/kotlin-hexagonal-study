package br.study.hexagonal.application.ports.`in`

import br.study.hexagonal.application.core.domain.Customer

interface UpdateCostumerInputPort {
    fun update(customer: Customer, zipCode: String)
}