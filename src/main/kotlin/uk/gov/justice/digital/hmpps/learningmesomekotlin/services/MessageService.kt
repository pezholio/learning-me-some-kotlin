package uk.gov.justice.digital.hmpps.learningmesomekotlin.services

import org.springframework.stereotype.Service
import uk.gov.justice.digital.hmpps.learningmesomekotlin.models.Message
import uk.gov.justice.digital.hmpps.learningmesomekotlin.repositories.MessageRepository

@Service
class MessageService(val db: MessageRepository) {
  fun findMessages(): List<Message> = db.findAll().toList()

  fun post(message: Message) {
    db.save(message)
  }
}
