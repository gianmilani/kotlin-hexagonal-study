package br.study.hexagonal.adapters.`in`.controller.response

data class CustomerResponse(
    val id: String,
    val name: String,
    val cpf: String,
    val isValidCpf: Boolean,
    val address: AddressResponse
)
