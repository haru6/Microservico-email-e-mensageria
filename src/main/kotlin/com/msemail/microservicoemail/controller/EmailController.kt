package com.msemail.microservicoemail.controller

import com.msemail.microservicoemail.adapter.Conversor
import com.msemail.microservicoemail.adapter.ConversorToDTO
import com.msemail.microservicoemail.dto.EmailDTO
import com.msemail.microservicoemail.service.EmailService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/email")
class EmailController(private val emailService: EmailService,
                      private val conversorToDTO: ConversorToDTO,
                      private val conversor: Conversor) {

    @PostMapping
    fun enviaEmail(@RequestBody @Valid emailDTO: EmailDTO): ResponseEntity<EmailDTO>{
        val emailModel = emailService.enviar(conversor.map(emailDTO))
        return ResponseEntity(conversorToDTO.map(emailModel), HttpStatus.CREATED)
    }

}