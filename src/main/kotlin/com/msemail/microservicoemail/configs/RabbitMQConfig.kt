package com.msemail.microservicoemail.configs

import ch.qos.logback.classic.pattern.MessageConverter
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Bean
    fun queue() = QueueBuilder.durable("ms-email").build()

    @Bean
    fun messageCoverter(objectMapper: ObjectMapper) = Jackson2JsonMessageConverter (objectMapper)

}