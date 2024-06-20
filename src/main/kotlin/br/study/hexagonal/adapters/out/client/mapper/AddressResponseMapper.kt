package br.study.hexagonal.adapters.out.client.mapper

import br.study.hexagonal.adapters.out.client.response.AddressResponse
import br.study.hexagonal.application.core.domain.Address

fun AddressResponse.toAddress() = Address(
    street = street,
    city = city,
    state = state
)