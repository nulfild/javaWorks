package com.example.pw18.manufactures;

import com.example.pw18.phones.Phone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("manufactures")
public class ManufactureController {
	private final String logPrefix = "[" + this.getClass().getName() + "] ";

	private final ManufactureService manufactureService;

	public ManufactureController(ManufactureService manufactureService) {
		log.info(logPrefix + "Initializing");
		this.manufactureService = manufactureService;
	}

	@DeleteMapping
	public void deleteById(@RequestParam Long id) {
		log.info(logPrefix + "Delete manufacture by id {}", id);
		manufactureService.deleteById(id);
	}

	@PostMapping
	public void save(
		@RequestBody Manufacture manufacture,
		@RequestParam Long phoneId
	) {
		log.info(logPrefix + "Save manufacture {} with phone id {}", manufacture, phoneId);
		manufactureService.save(manufacture, phoneId);
	}

	@GetMapping
	public List<ManufactureDTO> findAll() {
		log.info(logPrefix + "Find all manufactures");
		return manufactureService.findAll();
	}

	@GetMapping("/{id}")
	public Manufacture getById(@PathVariable("id") Long id) {
		log.info(logPrefix + "Find manufacture by id {}", id);
		return manufactureService.findById(id);
	}

	@GetMapping("/{id}/phone")
	public Phone getPhone(@PathVariable("id") Long id) {
		log.info(logPrefix + "Find manufacture's phone by id {}", id);
		return manufactureService.getPhone(id);
	}

	@GetMapping("/search")
	public List<ManufactureDTO> findByFilters(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address
	) {
		log.info(logPrefix + "Find manufacture by filters: " +
				"{name: \"{}\", address: \"{}\"}", name, address);
		return manufactureService.findByFilters(name, address);
	}
}
