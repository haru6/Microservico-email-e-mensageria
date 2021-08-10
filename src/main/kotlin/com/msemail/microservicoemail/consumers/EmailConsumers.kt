package com.msemail.microservicoemail.consumers

import com.msemail.microservicoemail.adapter.Conversor
import com.msemail.microservicoemail.dto.EmailDTO
import com.msemail.microservicoemail.service.EmailService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmailConsumers(private val emailService: EmailService, private val conversor: Conversor) {

//    @RabbitListener(queues = ["ms-email"])
//    fun listen(@Payload emailDTO: EmailDTO) = emailService.enviar(conversor.map(emailDTO))

    @RabbitListener(queues = ["ms-email"])
    fun listenBody(emailDTO: EmailDTO) = emailService.enviar(conversor.map(emailDTO))

}