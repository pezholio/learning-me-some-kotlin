package uk.gov.justice.digital.hmpps.learningmesomekotlin.controllers

import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.mockito.kotlin.check
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import uk.gov.justice.digital.hmpps.learningmesomekotlin.models.Message
import uk.gov.justice.digital.hmpps.learningmesomekotlin.services.MessageService

@WebMvcTest(MessageController::class)
class MessageControllerTest {
  @MockBean
  lateinit var service: MessageService

  @Autowired
  internal lateinit var mockMvc: MockMvc

  @Test
  fun `should list all existing messages`() {
    whenever(
      service.findMessages()
    )
      .thenReturn(
        listOf(Message("Foo"), Message("Bar"), Message("Baz"))
      )

    mockMvc
      .perform(MockMvcRequestBuilders.get("/"))
      .andExpect(MockMvcResultMatchers.status().isOk)
      .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize<Array<Any>>(3)))
      .andExpect(MockMvcResultMatchers.jsonPath("[0].text").value("Foo"))
      .andExpect(MockMvcResultMatchers.jsonPath("[1].text").value("Bar"))
      .andExpect(MockMvcResultMatchers.jsonPath("[2].text").value("Baz"))

    verify(service).findMessages()
  }

  @Test
  fun `should create a message`() {
    mockMvc
      .perform(
        MockMvcRequestBuilders.post("/")
          .content("{\"text\": \"Hello!\"}")
          .contentType(MediaType.APPLICATION_JSON)
      )
      .andExpect(MockMvcResultMatchers.status().isOk)

    verify(service).post(check { assertThat(it.text == "Hello!") })
  }
}
