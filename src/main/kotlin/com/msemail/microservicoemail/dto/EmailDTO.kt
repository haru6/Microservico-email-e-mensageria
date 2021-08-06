package com.msemail.microservicoemail.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class EmailDTO {
    @NotBlank
    var ownerRef: String = ""
    @NotBlank
    @Email
    var emailFrom: String = ""
    @NotBlank
    @Email
    var emailTo: String = ""
    @NotBlank
    var subject: String = ""
    @NotBlank
    var text: String = ""
}