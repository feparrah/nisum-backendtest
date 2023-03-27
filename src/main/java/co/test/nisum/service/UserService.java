package co.test.nisum.service;

import co.test.nisum.dto.UserRequest;
import co.test.nisum.dto.UserResponse;

public interface UserService {

	public UserResponse addUser(UserRequest request);

}
