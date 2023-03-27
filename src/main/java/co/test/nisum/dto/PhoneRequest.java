package co.test.nisum.dto;

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
public class PhoneRequest {

	@NotEmpty
	@Pattern(regexp = "\\d+", message = "El telefono solo puede tener digitos")
	private String number;
	@NotEmpty
	@Pattern(regexp = "\\d+", message = "El codigo de ciudad solo puede tener digitos")
	private String citycode;
	@NotEmpty
	@Pattern(regexp = "\\d+", message = "El codigo de pais solo puede tener digitos")
	private String countrycode;
}
