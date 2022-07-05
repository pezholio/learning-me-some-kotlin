package uk.gov.justice.digital.hmpps.learningmesomekotlin.models

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "messages")
class Message(
  val text: String? = null,
  @Id
  val id: UUID = UUID.randomUUID()
)
