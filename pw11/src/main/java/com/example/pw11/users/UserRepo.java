package pw11.src.main.java.com.example.pw11.users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo
	extends CrudRepository<User, Long> {
	User findByName(String name);
}
