package br.study.hexagonal.adapters.`in`.consumer

import org.springframework.messaging.handler.annotation.Payload


class CostumerMessage(
    var isValidCpf: Boolean
) {
    lateinit var id: String
    lateinit var name: String
    lateinit var zipCode: String
    lateinit var cpf: String
}
