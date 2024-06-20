package br.study.hexagonal.config

import org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerConfig.*
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


@Configuration
class KafkaProducerConfig {

    @Bean
    fun producerFactory(): ProducerFactory<String, String> {
        val config = mutableMapOf<String, Any>()
        config[BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[GROUP_ID_CONFIG] = "hexags"
        config[KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        config[VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        return DefaultKafkaProducerFactory(config)
    }

    @Bean
    fun kafkaTemplate(producer: ProducerFactory<String, String>) = KafkaTemplate(producer)
}