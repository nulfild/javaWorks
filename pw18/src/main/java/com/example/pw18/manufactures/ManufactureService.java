package com.example.pw18.manufactures;

import com.example.pw18.phones.Phone;
import com.example.pw18.phones.MyPhoneRepo;
import java.util.List;

import com.example.pw18.phones.PhoneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManufactureService {
	private final String logPrefix = "[" + this.getClass().getName() + "] ";
	private final MyManufactureRepo myManufactureRepo;
	private final ManufactureRepo manufactureRepo;

	private final MyPhoneRepo myPhoneRepo;
	private final PhoneRepo phoneRepo;

	public ManufactureService(
			MyManufactureRepo myManufactureRepo,
			ManufactureRepo manufactureRepo,
			MyPhoneRepo myPhoneRepo,
			PhoneRepo phoneRepo
	) {
		log.info(logPrefix + "Initializing");
		this.myManufactureRepo = myManufactureRepo;
		this.manufactureRepo = manufactureRepo;
		this.myPhoneRepo = myPhoneRepo;
		this.phoneRepo = phoneRepo;
	}

	public void save(Manufacture manufacture, Long phoneId) {
		log.info(logPrefix + "Save manufacture {} with phone id {}", manufacture, phoneId);
		manufacture.setPhone(phoneRepo.findById(phoneId).get());
		manufactureRepo.save(manufacture);
	}

	public List<ManufactureDTO> findAll() {
		log.info(logPrefix + "Find all manufactures");
		return manufactureRepo.findAll().stream().map(ManufactureDTO::withoutPhone).toList();
	}

	public void deleteById(Long id) {
		log.info(logPrefix + "Delete manufacture by id {}", id);
		manufactureRepo.deleteById(id);
	}

	public Manufacture findById(Long id) {
		log.info(logPrefix + "Find manufacture by id {}", id);
		return myManufactureRepo.findById(id);
	}

	public Phone getPhone(Long id) {
		log.info(logPrefix + "Find manufacture's phone by id {}", id);
		return findById(id).getPhone();
	}

	public List<ManufactureDTO> findByFilters(String name, String address) {
		log.info(logPrefix + "Find manufacture by filters: " +
				"{name: \"{}\", address: \"{}\"}", name, address);
		return myManufactureRepo
				.findByFilters(name, address).stream()
				.map(ManufactureDTO::withPhone).toList();
	}
}
