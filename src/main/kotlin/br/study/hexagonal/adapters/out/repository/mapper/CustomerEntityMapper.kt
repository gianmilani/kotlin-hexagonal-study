package br.study.hexagonal.adapters.out.repository.mapper

import br.study.hexagonal.adapters.out.repository.entity.AddressEntity
import br.study.hexagonal.adapters.out.repository.entity.CustomerEntity
import br.study.hexagonal.application.core.domain.Address
import br.study.hexagonal.application.core.domain.Customer

fun Customer.toCustomerEntity() = CustomerEntity(
    name = name,
    address = address?.toAddressEntity() ?: throw RuntimeException(""),
    cpf = cpf,
    isValidCpf = isValidCpf
)

fun Address.toAddressEntity() = AddressEntity(
    street = street,
    city = city,
    state = state,
)

fun CustomerEntity.toCustomer(): Customer = Customer(
    name = name,
    cpf = cpf
).apply {
    id = this@toCustomer.id
    address = this@toCustomer.address.toAddress()
}


fun AddressEntity.toAddress() = Address(
    street = street,
    city = city,
    state = state,
)