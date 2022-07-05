package uk.gov.justice.digital.hmpps.learningmesomekotlin.repositories

import org.springframework.data.repository.CrudRepository
import uk.gov.justice.digital.hmpps.learningmesomekotlin.models.Message
import java.util.UUID

interface MessageRepository : CrudRepository<Message, UUID>
