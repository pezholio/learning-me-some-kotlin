package uk.gov.justice.digital.hmpps.learningmesomekotlin.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import uk.gov.justice.digital.hmpps.learningmesomekotlin.models.Message
import uk.gov.justice.digital.hmpps.learningmesomekotlin.services.MessageService

@RestController
class MessageController(val service: MessageService) {
  @GetMapping("/")
  fun index(): List<Message> = service.findMessages()

  @PostMapping("/")
  fun post(@RequestBody message: Message) {
    service.post(message)
  }
}
