package co.test.nisum.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import co.test.nisum.dto.UserResponse;
import co.test.nisum.exception.BadRequestException;
import co.test.nisum.model.User;
import co.test.nisum.repository.UserRepository;
import co.test.nisum.service.impl.UserServiceImpl;
import co.test.nisum.util.Generator;

@SpringBootTest
class UserServiceTest {
	
	@Mock
	private UserRepository repository;
	
	@Mock
	private ModelMapper mapper;
	
	@InjectMocks
	private UserServiceImpl service;
	
	@BeforeEach
	public void setup() {
		ReflectionTestUtils.setField(service, "secret", "secret");	
	}
	
	@Test
	void testAddUser_SUCCESS() {
		when(mapper.map(Generator.genRequest(), User.class)).thenReturn(Generator.genEntity().get());
		when(mapper.map(Generator.genEntity(), UserResponse.class)).thenReturn(Generator.genResponse());
		when(repository.existsByEmail(any())).thenReturn(false);
		when(repository.findById(any())).thenReturn(Generator.genEntity());
		when(repository.save(any())).thenReturn(Generator.genEntity().get());
		UserResponse response = service.addUser(Generator.genRequest());
		verify(repository, times(1)).save(any());
	}
	
	@Test
	void testAddUser_FAIL() {
		when(mapper.map(Generator.genRequest(), User.class)).thenReturn(Generator.genEntity().get());
		when(mapper.map(Generator.genEntity(), UserResponse.class)).thenReturn(Generator.genResponse());
		when(repository.existsByEmail(any())).thenReturn(true);
		when(repository.findById(any())).thenReturn(Generator.genEntity());
		when(repository.save(any())).thenReturn(Generator.genEntity().get());
		assertThrows(BadRequestException.class, ()-> {service.addUser(Generator.genRequest());});
		verify(repository, times(1)).existsByEmail(anyString());
	}

}
