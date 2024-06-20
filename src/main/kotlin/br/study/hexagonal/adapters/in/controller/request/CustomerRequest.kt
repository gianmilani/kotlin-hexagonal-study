package br.study.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @NotBlank
    val name: String,
    @NotBlank
    val cpf: String,
    @NotBlank
    val zipCode: String
)
