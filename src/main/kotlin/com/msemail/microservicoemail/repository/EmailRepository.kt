package com.msemail.microservicoemail.repository

import com.msemail.microservicoemail.model.EmailModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EmailRepository : JpaRepository<EmailModel, UUID> {
}