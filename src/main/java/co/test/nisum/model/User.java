package co.test.nisum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(insertable = false, updatable = false, nullable = false)
	private UUID id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	List<Phone> phones = new ArrayList<>();
	
	@Column
	private String token;
	
	@Column
	@CreatedDate
	private LocalDateTime created = LocalDateTime.now();
	
	@Column
	@LastModifiedDate
	private LocalDateTime modified = LocalDateTime.now();
	
	@Column(name = "last_login")
	@LastModifiedDate
	private LocalDateTime lastLogin = LocalDateTime.now();
	
	@Column
	private Boolean isactive = true;
	
	
}
