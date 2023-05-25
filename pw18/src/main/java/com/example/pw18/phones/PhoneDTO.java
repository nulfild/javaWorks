package com.example.pw18.phones;

import com.example.pw18.manufactures.ManufactureDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {
    private Long id;
    private String name;
    private int creationYear;

    private List<ManufactureDTO> manufactures;

    public static PhoneDTO withoutManufacture(Phone phone) {
        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId(phone.getId());
        phoneDTO.setName(phone.getName());
        phoneDTO.setCreationYear(phone.getCreationYear());

        log.info("Create PhoneDTO WITHOUT manufacture: {}", phoneDTO);

        return phoneDTO;
    }

    public static PhoneDTO withManufacture(Phone phone) {
        PhoneDTO phoneDTO = withoutManufacture(phone);

        phoneDTO.setManufactures(
                phone.getManufactures().stream().map(ManufactureDTO::withoutPhone).toList()
        );

        log.info("Create PhoneDTO WITH manufacture: {}", phoneDTO);

        return phoneDTO;
    }

    @Override
    public String toString() {
        return "PhoneDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationYear=" + creationYear +
                ", manufactures=" + manufactures +
                '}';
    }
}
