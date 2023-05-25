package com.example.pw16.phones;

import com.example.pw16.manufactures.Manufacture;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneRepo {

	private final JdbcTemplate jdbcTemplate;
	private final RowMapper<Phone> phoneRawMapper;
	private final RowMapper<Manufacture> manufactureRowMapper;

	public PhoneRepo(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		phoneRawMapper =
			new BeanPropertyRowMapper<>(Phone.class);
		manufactureRowMapper =
			new BeanPropertyRowMapper<>(Manufacture.class);
	}

	public List<Phone> findAll() {
		String sql = "SELECT * FROM phones";
		return jdbcTemplate.query(sql, phoneRawMapper);
	}

	public Phone findById(Long id) {
		String sql = "SELECT * FROM phones WHERE id = ?";
		Phone phone = jdbcTemplate
			.query(sql, phoneRawMapper, id)
			.get(0);

		phone.setManufactures(getManufactureByPhoneId(id));
		return phone;
	}

	private List<Manufacture> getManufactureByPhoneId(
		Long id
	) {
		String sql =
			"SELECT m.name, m.address, m.id FROM manufactures m " +
			"WHERE m.phone_id = ?";

		return jdbcTemplate.query(
			sql,
			manufactureRowMapper,
			id
		);
	}

	public void save(Phone phone) {
		String sql =
			"INSERT INTO phones (name, creation_year) VALUES (?, ?)";
		jdbcTemplate.update(
			sql,
			phone.getName(),
			phone.getCreationYear()
		);
	}

	public void deleteById(Long id) {
		String sql = "DELETE FROM phones WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
