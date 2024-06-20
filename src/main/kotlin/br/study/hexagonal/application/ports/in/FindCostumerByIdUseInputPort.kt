package br.study.hexagonal.application.ports.`in`

import br.study.hexagonal.application.core.domain.Customer

interface FindCostumerByIdUseInputPort {
    fun find(id: String): Customer
}