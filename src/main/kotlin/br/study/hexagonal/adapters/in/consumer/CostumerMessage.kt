package br.study.hexagonal.adapters.`in`.consumer

data class CostumerMessage(
    val id: String,
    val name: String,
    val zipCode: String,
    val cpf: String,
    var isValidCpf: Boolean
)
