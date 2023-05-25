package com.example.pw18.phones;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PhoneService {
	private final String logPrefix = "[" + this.getClass().getName() + "] ";
	private final MyPhoneRepo myPhoneRepo;
	private final PhoneRepo phoneRepo;

	public PhoneService(MyPhoneRepo myPhoneRepo, PhoneRepo phoneRepo) {
		log.info(logPrefix + "Initializing");
		this.phoneRepo = phoneRepo;
		this.myPhoneRepo = myPhoneRepo;
	}

	public void save(Phone phone) {
		log.info(logPrefix + "Save phone {}", phone);
		phoneRepo.save(phone);
	}

	public void deleteById(Long id) {
		log.info(logPrefix + "Delete phone by id {}", id);
		phoneRepo.deleteById(id);
	}

	public List<PhoneDTO> findAll() {
		log.info(logPrefix + "Find all phones");
		return phoneRepo.findAll().stream().map(PhoneDTO::withoutManufacture).toList();
	}

	public Phone findById(Long id) {
		log.info(logPrefix + "Find phone by id {}", id);
		return myPhoneRepo.findById(id);
	}

	public List<PhoneDTO> findByFilters(
			String name, String creationYear
	) {
		log.info(logPrefix + "Find phone by filters: " +
				"{name: \"{}\", creationYear: \"{}\"}", name, creationYear);
		return myPhoneRepo.findByFilters(name, creationYear)
				.stream().map(PhoneDTO::withManufacture).toList();
	}
}
