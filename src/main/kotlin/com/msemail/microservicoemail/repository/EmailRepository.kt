package com.msemail.microservicoemail.repository

import com.msemail.microservicoemail.model.EmailModel
import org.springframework.data.jpa.repository.JpaRepository

interface EmailRepository : JpaRepository<EmailModel, Long> {
}