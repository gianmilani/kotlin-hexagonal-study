package br.study.hexagonal.application.core.domain

data class Customer(
    var id: String? = null,
    var address: Address? = null,
    val name: String,
    val cpf: String,
    var isValidCpf: Boolean = false
)
