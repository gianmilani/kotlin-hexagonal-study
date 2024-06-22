package br.study.hexagonal.adapters.`in`.consumer.mapper

import br.study.hexagonal.adapters.`in`.consumer.CostumerMessage
import br.study.hexagonal.application.core.domain.Customer


fun CostumerMessage.toCostumer() =
    Customer(
        name = name,
        cpf = cpf,
        isValidCpf = isValidCpf
    ).apply {
        id = this@toCostumer.id
    }