package com.msemail.microservicoemail.configs

import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DirectCongif(private val queue: Queue) {

    @Bean
    fun directExchange(): Exchange = ExchangeBuilder.directExchange("email").durable(true).build()

    @Bean
    fun firstBinding(): Binding = BindingBuilder.bind(queue).to(directExchange()).with("").noargs()
}