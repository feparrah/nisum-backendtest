package co.test.nisum.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private UUID id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	private LocalDateTime lastLogin;
	
	private String token;
	
	private Boolean isactive;
}
