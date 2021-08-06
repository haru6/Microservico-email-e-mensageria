package com.msemail.microservicoemail.service

import com.msemail.microservicoemail.enum.StatusEmail
import com.msemail.microservicoemail.model.EmailModel
import com.msemail.microservicoemail.repository.EmailRepository
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

import java.time.LocalDateTime

@Service
class EmailService (private val emailRepository: EmailRepository, private val emailSender: JavaMailSender){

    fun enviar(emailModel: EmailModel): EmailModel{
        emailModel.sendDataEmail = LocalDateTime.now()
        try {
            var mensagem = SimpleMailMessage()
            mensagem.setFrom(emailModel.emailFrom)
            mensagem.setTo(emailModel.emailTo)
            mensagem.setSubject(emailModel.subject)
            mensagem.setText(emailModel.text)
            emailSender.send(mensagem)
            emailModel.statusEmail = StatusEmail.SENT
        }catch (e: MailException){
            emailModel.statusEmail = StatusEmail.ERROR
            println(e)
        }
        finally {
            return emailRepository.save(emailModel)
        }
    }
}