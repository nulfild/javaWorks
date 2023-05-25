package com.example.pw16.manufactures;

import com.example.pw16.phones.Phone;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ManufactureRepo {

	public JdbcTemplate jdbcTemplate;
	private final RowMapper<Manufacture> manufactureRowMapper;

	public ManufactureRepo(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		manufactureRowMapper =
			(rs, rowNum) -> {
				Manufacture manufacture = new Manufacture();
				manufacture.setId(rs.getLong("id"));
				manufacture.setName(rs.getString("name"));
				manufacture.setName(rs.getString("address"));
				Long phoneId = rs.getLong("phone_id");
				if (phoneId != null) {
					Phone phone = new Phone();
					phone.setId(phoneId);
					phone.setName(rs.getString("phone_name"));
					phone.setCreationYear(
						rs.getInt("phone_creation_year")
					);
					manufacture.setPhone(phone);
				}
				return manufacture;
			};
	}

	public List<Manufacture> findAll() {
		String sql =
			"SELECT m.*, p.name AS phone_name, p.creation_year AS phone_creation_year " +
			"FROM manufactures m " +
			"LEFT JOIN phones p ON m.phone_id = p.id";
		return jdbcTemplate.query(sql, manufactureRowMapper);
	}

	public Manufacture findById(Long id) {
		String sql =
			"SELECT m.*, p.name AS phone_name, p.creation_year AS phone_creation_year " +
			"FROM manufactures m " +
			"LEFT JOIN phones p ON m.phone_id = p.id " +
			"WHERE m.id = ?";

		return jdbcTemplate
			.query(sql, manufactureRowMapper, id)
			.get(0);
	}

	public void save(Manufacture manufacture) {
		String sql =
			"INSERT INTO manufactures (name, address, phone_id) VALUES (?, ?, ?)";
		jdbcTemplate.update(
			sql,
			manufacture.getName(),
			manufacture.getAddress(),
			manufacture.getPhone().getId()
		);
	}

	public void deleteById(Long id) {
		String sql = "DELETE FROM manufactures WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
