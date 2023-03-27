package co.test.nisum.service.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.test.nisum.dto.UserRequest;
import co.test.nisum.dto.UserResponse;
import co.test.nisum.exception.BadRequestException;
import co.test.nisum.model.User;
import co.test.nisum.repository.UserRepository;
import co.test.nisum.service.UserService;
import co.test.nisum.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	@Value("${jwt.secret}")
	private String secret;
	
	private final ModelMapper modelMapper;

	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserResponse addUser(UserRequest request) {
		
		if(userRepository.existsByEmail(request.getEmail())) {
			throw new BadRequestException("El correo ya se encuentra registrado");
		}
		
		User user = modelMapper.map(request, User.class);
		user.setToken(JWTUtil.generateJWT(secret, user.getName()));
		user = userRepository.save(user);
		log.info("Created user id: {}", user.getId());
		User createdUser = findUser(user.getId());
		return modelMapper.map(createdUser, UserResponse.class);
	}
	
	private User findUser(UUID id) {
		return userRepository.findById(id).get();
	}
	

}
