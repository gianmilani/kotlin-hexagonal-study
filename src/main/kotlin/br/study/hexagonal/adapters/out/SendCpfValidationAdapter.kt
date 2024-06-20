package br.study.hexagonal.adapters.out

import br.study.hexagonal.application.ports.out.SendCpfValidationOutPutPort
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SendCpfValidationAdapter(
    private val kafkaTemplate: KafkaTemplate<String, String>
) : SendCpfValidationOutPutPort {
    override fun send(cpf: String) {
        kafkaTemplate.send("tp-cpf-validate", cpf)
    }
}