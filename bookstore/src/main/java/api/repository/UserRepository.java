package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.model.Users;



public interface UserRepository extends JpaRepository<Users, Long> {
	
	Users findOneByUsername(String username);
	

}
