package com.example.pw18.manufactures;

import com.example.pw18.phones.Phone;
import java.util.List;
import javax.sql.DataSource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class MyManufactureRepo {
	private final String logPrefix = "[" + this.getClass().getName() + "] ";
	public JdbcTemplate jdbcTemplate;
	private final RowMapper<Manufacture> manufactureRowMapper;

	@PersistenceContext
	private EntityManager entityManager;

	public MyManufactureRepo(DataSource dataSource) {
		log.info(logPrefix + "Initializing");

		jdbcTemplate = new JdbcTemplate(dataSource);
		manufactureRowMapper =
			(rs, rowNum) -> {
				Manufacture manufacture = new Manufacture();
				manufacture.setId(rs.getLong("id"));
				manufacture.setName(rs.getString("name"));
				manufacture.setAddress(rs.getString("address"));
				long phoneId = rs.getLong("phone_id");
				if (phoneId != 0) {
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

	public Manufacture findById(Long id) {
		log.info(logPrefix + "Find manufacture by id {}", id);

		String sql =
			"SELECT m.*, p.name AS phone_name, p.creation_year AS phone_creation_year " +
			"FROM manufactures m " +
			"LEFT JOIN phones p ON m.phone_id = p.id " +
			"WHERE m.id = ?";

		return jdbcTemplate
			.query(sql, manufactureRowMapper, id)
			.get(0);
	}

	public List<Manufacture> findByFilters(String name, String address) {
		log.info(logPrefix + "Find manufacture by filters: " +
				"{name: \"{}\", address: \"{}\"}", name, address);

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Manufacture> query = builder.createQuery(Manufacture.class);
		Root<Manufacture> manufactureRoot = query.from(Manufacture.class);

		Predicate predicate = builder.conjunction();

		if (name != null && !name.isEmpty()) {
			predicate = builder.and(predicate, builder.like(manufactureRoot.get("name"), name));
		}
		if (address != null && !address.isEmpty()) {
			predicate = builder.and(predicate, builder.like(manufactureRoot.get("address"), address));
		}

		query.where(predicate);
		return entityManager.createQuery(query).getResultList();
	}
}
