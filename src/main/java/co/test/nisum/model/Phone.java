package co.test.nisum.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phone {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private Long number;
	
	@Column
	private Long citycode;
	
	@Column
	private Long countrycode;
}
