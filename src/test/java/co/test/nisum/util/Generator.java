package co.test.nisum.util;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.test.nisum.dto.PhoneRequest;
import co.test.nisum.dto.UserRequest;
import co.test.nisum.dto.UserResponse;
import co.test.nisum.model.Phone;
import co.test.nisum.model.User;

public class Generator {

	public static UserRequest genRequest() {
		return UserRequest.builder().email("test@ooo.com").name("test").password("123456789a")
				.phones(List.of(PhoneRequest.builder().citycode("1").countrycode("57").number("123456").build()))
				.build();
	}

	public static UserResponse genResponse() {
		return UserResponse.builder().created(LocalDateTime.now()).id(UUID.fromString("decc525d-4d5d-499d-b564-d8ef23d9cd97")).isactive(true)
				.lastLogin(LocalDateTime.now()).modified(LocalDateTime.now()).token("token").build();
	}
	
	public static UserRequest genRequestFail() {
		return UserRequest.builder().email("test@ooocom").name("test").password("123456789a")
				.phones(List.of(PhoneRequest.builder().citycode("1").countrycode("57").number("123456").build()))
				.build();
	}
	
	public static Optional<User> genEntity() {
		Phone phone = new Phone(1l, 123456l, 1l, 57l);
		User user = new User(UUID.fromString("decc525d-4d5d-499d-b564-d8ef23d9cd97"), "test", "test@ooo.com", "123456789a", List.of(phone), "token", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), true);
		return Optional.of(user);
	}

}
