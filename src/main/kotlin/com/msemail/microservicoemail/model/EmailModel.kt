package com.msemail.microservicoemail.model

import com.msemail.microservicoemail.enum.StatusEmail
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name="TB_EMAIL")
class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val emailId: UUID? = null
    var ownerRef: String = ""
    var emailFrom: String = ""
    var emailTo: String = ""
    var subject: String =""

    @Column(columnDefinition = "TEXT")
    var text: String = ""
    var sendDataEmail: LocalDateTime = LocalDateTime.now()
    var statusEmail: StatusEmail = StatusEmail.WAIT
}