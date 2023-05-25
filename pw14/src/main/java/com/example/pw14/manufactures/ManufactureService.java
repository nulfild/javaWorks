package com.example.pw14.manufactures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufactureService {

	@Autowired
	private ManufactureRepo manufactureRepo;

	public Manufacture save(Manufacture manufacture) {
		return manufactureRepo.save(manufacture);
	}

	public Iterable<Manufacture> findAll() {
		return manufactureRepo.findAll();
	}

	public void deleteById(Long id) {
		manufactureRepo.deleteById(id);
	}
}
