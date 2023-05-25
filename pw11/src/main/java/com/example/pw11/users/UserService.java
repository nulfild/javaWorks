package pw11.src.main.java.com.example.pw11.users;

import com.example.pw11.users.exceptions.UserAlreadyExistException;
import com.example.pw11.users.exceptions.UserNotFoundException;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User registration(User user)
		throws UserAlreadyExistException {
		if (userRepo.findByName(user.getName()) != null) {
			throw new UserAlreadyExistException(
				"User already exists"
			);
		}
		return userRepo.save(user);
	}

	public User getOne(Long id)
		throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}

		return user.get();
	}
}
