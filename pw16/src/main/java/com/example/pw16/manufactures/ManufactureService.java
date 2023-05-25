package com.example.pw16.manufactures;

import com.example.pw16.phones.Phone;
import com.example.pw16.phones.PhoneRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufactureService {

	@Autowired
	private ManufactureRepo manufactureRepo;

	@Autowired
	private PhoneRepo phoneRepo;

	public void save(Manufacture manufacture, Long id) {
		manufacture.setPhone(phoneRepo.findById(id));
		manufactureRepo.save(manufacture);
	}

	public List<Manufacture> findAll() {
		return manufactureRepo.findAll();
	}

	public void deleteById(Long id) {
		manufactureRepo.deleteById(id);
	}

	public Manufacture findById(Long id) {
		return manufactureRepo.findById(id);
	}

	public Phone getPhone(Long id) {
		return findById(id).getPhone();
	}
}
