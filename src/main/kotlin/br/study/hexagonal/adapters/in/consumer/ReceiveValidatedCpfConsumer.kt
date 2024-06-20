package br.study.hexagonal.adapters.`in`.consumer

import br.study.hexagonal.adapters.`in`.consumer.mapper.toCostumer
import br.study.hexagonal.application.ports.`in`.UpdateCostumerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ReceiveValidatedCpfConsumer(
    private val updateCostumerInputPort: UpdateCostumerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "hexags")
    fun receiveMessage(customerMessage: CostumerMessage) {
        val customer = customerMessage.toCostumer()
        updateCostumerInputPort.update(customer, customerMessage.zipCode)
    }
}