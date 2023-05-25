package pw11.src.main.java.com.example.pw11.users;

import com.example.pw11.users.exceptions.UserAlreadyExistException;
import com.example.pw11.users.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<String> registration(
		@RequestBody User user
	) {
		try {
			userService.registration(user);
			return ResponseEntity.ok(
				"User successfully saved"
			);
		} catch (UserAlreadyExistException e) {
			return ResponseEntity
				.badRequest()
				.body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<String> getOneUser(
		@RequestParam Long id
	) {
		try {
			return ResponseEntity.ok(
				userService.getOne(id).toString()
			);
		} catch (UserNotFoundException e) {
			return ResponseEntity
				.badRequest()
				.body(e.getMessage());
		}
	}
}
