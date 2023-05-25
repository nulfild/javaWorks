package pw11.src.main.java.com.example.pw11.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String pass;

	public User(String name) {
		this.name = name;
	}

	public User() {}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return (
			"User: {" +
			"\n\tid: " +
			id +
			",\n\tname: " +
			"\"" +
			name +
			"\"" +
			"\n}"
		);
	}
}
