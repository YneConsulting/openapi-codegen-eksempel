package no.yne.openapiexample.server

import org.openapitools.api.MessageApi
import org.openapitools.model.Message
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ApiController: MessageApi {
	private val messages = listOf(
		"Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
		"Vestibulum augue urna, tempus sed lobortis et, ullamcorper id tortor.",
		"Etiam laoreet vestibulum posuere.",
		"Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
		"Nulla dignissim nunc ac turpis lobortis, venenatis aliquet sapien auctor.",
		"Nunc ut ex imperdiet, posuere sem et, molestie lorem.",
		"Proin gravida id sapien vel commodo.",
		"Donec congue hendrerit magna sit amet ultricies.",
		"Nam suscipit, velit quis dapibus dictum, neque enim lobortis urna, in convallis orci mi eget turpis.",
	)

	private fun getRandomMessage(): String {
		return messages.random()
	}

	@CrossOrigin
	override fun messageGet(): ResponseEntity<Message> {
		val id = UUID.randomUUID()
		val message = getRandomMessage()
		val messageObject = Message().id(id).message(message)
		return ResponseEntity.of(Optional.of(messageObject))
	}
}