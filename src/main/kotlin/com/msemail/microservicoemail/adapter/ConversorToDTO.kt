package com.msemail.microservicoemail.adapter

import com.msemail.microservicoemail.adapter.`interface`.Map
import com.msemail.microservicoemail.dto.EmailDTO
import com.msemail.microservicoemail.model.EmailModel
import org.springframework.stereotype.Component

@Component
class ConversorToDTO: Map<EmailModel, EmailDTO> {

    override fun map(emailModel: EmailModel): EmailDTO {
        val emailDTO = EmailDTO()
        emailDTO.ownerRef = emailModel.ownerRef
        emailDTO.emailFrom = emailModel.emailFrom
        emailDTO.emailTo = emailModel.emailTo
        emailDTO.subject = emailModel.subject
        emailDTO.text = emailModel.text
        return emailDTO
    }

}