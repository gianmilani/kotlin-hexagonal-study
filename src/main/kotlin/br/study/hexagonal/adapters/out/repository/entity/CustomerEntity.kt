package br.study.hexagonal.adapters.out.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class CustomerEntity(
    val name: String,
    val address: AddressEntity,
    val cpf: String,
    var isValidCpf: Boolean = false,
) {
    @Id
    lateinit var id: String
}