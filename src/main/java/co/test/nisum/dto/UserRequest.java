package co.test.nisum.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserRequest {
	
	@NotEmpty(message = "El nombre es requerido")
	private String name;
	@NotEmpty(message = "El correo es requerido")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "El correo es invalido")
	private String email;
	@NotEmpty(message = "La contraseña es requerida")
	private String password;
	@Valid
	private List<PhoneRequest> phones;

}
