package com.example.pw14.phones;

import org.springframework.stereotype.Service;

@Service
public class PhoneService {

	private PhoneRepo phoneRepo;

	public PhoneService(PhoneRepo phoneRepo) {
		this.phoneRepo = phoneRepo;
	}

	public Phone save(Phone phone) {
		return phoneRepo.save(phone);
	}

	public void deleteById(Long id) {
		phoneRepo.deleteById(id);
	}

	public Iterable<Phone> findAll() {
		return phoneRepo.findAll();
	}
}
