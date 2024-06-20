package br.study.hexagonal.adapters.`in`.controller.mapper

import br.study.hexagonal.adapters.`in`.controller.request.CustomerRequest
import br.study.hexagonal.adapters.`in`.controller.response.AddressResponse
import br.study.hexagonal.adapters.`in`.controller.response.CustomerResponse
import br.study.hexagonal.application.core.domain.Address
import br.study.hexagonal.application.core.domain.Customer

fun CustomerRequest.toCustomer() = Customer(
    name = name,
    cpf = cpf
)

fun Customer.toCustomerResponse() = CustomerResponse(
    id = id!!,
    name = name,
    cpf = cpf,
    address = address!!.toAddressResponse(),
    isValidCpf = isValidCpf
)

fun Address.toAddressResponse() = AddressResponse(
    street = street,
    city = city,
    state = state
)