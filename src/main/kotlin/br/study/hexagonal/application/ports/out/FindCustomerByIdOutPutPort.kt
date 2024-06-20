package br.study.hexagonal.application.ports.out

import br.study.hexagonal.application.core.domain.Customer

interface FindCustomerByIdOutPutPort {
    fun find(id: String): Customer?
}