package br.study.hexagonal.application.core.domain

data class Customer(
    val name: String,
    val cpf: String,
    var isValidCpf: Boolean = false
) {
    lateinit var id: String
    lateinit var address: Address
}
