package com.example.pw18.manufactures;

import com.example.pw18.phones.Phone;
import com.example.pw18.phones.PhoneDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManufactureDTO {
    private Long id;
    private String name;
    private String address;

    private PhoneDTO phone;

    public static ManufactureDTO withoutPhone(Manufacture manufacture) {
        ManufactureDTO manufactureDTO = new ManufactureDTO();

        manufactureDTO.setId(manufacture.getId());
        manufactureDTO.setName(manufacture.getName());
        manufactureDTO.setAddress(manufacture.getAddress());

        log.info("Create ManufactureDTO WITHOUT phone: {}", manufactureDTO);

        return manufactureDTO;
    }

    public static ManufactureDTO withPhone(Manufacture manufacture) {
        ManufactureDTO manufactureDTO = withoutPhone(manufacture);

        manufactureDTO.setPhone(
                PhoneDTO.withoutManufacture(manufacture.getPhone())
        );

        log.info("Create ManufactureDTO WITH phone: {}", manufactureDTO);

        return manufactureDTO;
    }

    @Override
    public String toString() {
        return "ManufactureDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
