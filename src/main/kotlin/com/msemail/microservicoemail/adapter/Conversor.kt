package com.msemail.microservicoemail.adapter

import com.msemail.microservicoemail.adapter.`interface`.Map
import com.msemail.microservicoemail.dto.EmailDTO
import com.msemail.microservicoemail.enum.StatusEmail
import com.msemail.microservicoemail.model.EmailModel
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class Conversor : Map<EmailDTO, EmailModel> {

    override fun map(emailDTO: EmailDTO): EmailModel {
        val emailModel = EmailModel()
        emailModel.ownerRef = emailDTO.ownerRef
        emailModel.emailFrom = emailDTO.emailFrom
        emailModel.emailTo = emailDTO.emailTo
        emailModel.subject = emailDTO.subject
        emailModel.text = emailDTO.text
        return emailModel
    }
}