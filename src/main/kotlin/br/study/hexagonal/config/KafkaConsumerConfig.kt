package br.study.hexagonal.config

import br.study.hexagonal.adapters.`in`.consumer.CostumerMessage
import org.apache.kafka.clients.consumer.ConsumerConfig.*
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {


    @Bean
    fun consumerFactory(): ConsumerFactory<String, CostumerMessage> {
        val config = mutableMapOf<String, Any>()
        config[BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        config[GROUP_ID_CONFIG] = "hexags"
        config[KEY_DESERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        config[VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        config[AUTO_OFFSET_RESET_CONFIG] = "earliest"
        return DefaultKafkaConsumerFactory(config, StringDeserializer(), JsonDeserializer(CostumerMessage::class.java))
    }

    @Bean
    fun kafkaListenerContainerFactory(
        consumerFactory: ConsumerFactory<String, CostumerMessage>
    ): ConcurrentKafkaListenerContainerFactory<String, CostumerMessage> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, CostumerMessage>()
        factory.consumerFactory = consumerFactory
        return factory
    }
}