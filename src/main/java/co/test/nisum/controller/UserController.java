package co.test.nisum.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.test.nisum.dto.ErrorResponse;
import co.test.nisum.dto.UserRequest;
import co.test.nisum.dto.UserResponse;
import co.test.nisum.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	@Value("${regex.password}")
	private String regexp;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> postUser(@Valid @RequestBody UserRequest request) {
		log.info("Entering create new User... ");
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(request.getPassword());
		if(!matcher.matches()) {
			return new ResponseEntity<Object>(new ErrorResponse("La contraseña no cumple los requisitos"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>( userService.addUser(request), HttpStatus.CREATED);
	}

}
