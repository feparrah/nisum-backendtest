package co.test.nisum.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.test.nisum.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
	
	public Boolean existsByEmail(String email);
}
