package net.alkemi.repository.bd;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import net.alkemi.entity.users;

public interface UsersRepository extends JpaRepository<users, String> {

	@Query(value = "SELECT * FROM disney.users;", nativeQuery = true)
	List<users> getusersTodo();
	
	@Query(value="SELECT * FROM disney.users where username='username'",nativeQuery = true)
	List<users> getUsername();
}
