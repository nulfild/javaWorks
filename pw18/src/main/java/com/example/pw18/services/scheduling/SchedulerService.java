package com.example.pw18.services.scheduling;

import com.example.pw18.manufactures.ManufactureDTO;
import com.example.pw18.manufactures.ManufactureService;
import com.example.pw18.phones.PhoneDTO;
import com.example.pw18.phones.PhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

interface IWriteData {
    void exec(FileWriter writer) throws IOException;
}

@Service
@Slf4j
@ManagedResource(objectName = "com.example.pw18:name=SchedulerService")
public class SchedulerService {
    private final PhoneService phoneService;
    private final ManufactureService manufactureService;

    public SchedulerService(PhoneService phoneService, ManufactureService manufactureService) {
        this.phoneService = phoneService;
        this.manufactureService = manufactureService;
    }

    private void generateFile(String path, IWriteData writeData) {
        try {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writeData.exec(writer);
            writer.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @ManagedOperation(description = "Creates DB files")
    @Scheduled(fixedDelay = 1800_000)
    public void generateFiles() {
        generateFile("phonesDB.txt", writer -> {
            List<PhoneDTO> phones = phoneService.findAll();
            for (PhoneDTO phone : phones) {
                writer.write(phone.toString());
                writer.write(System.lineSeparator());
            }
        });

        generateFile("manufacturesDB.txt", writer -> {
            List<ManufactureDTO> manufactures = manufactureService.findAll();
            for (ManufactureDTO manufacture : manufactures) {
                writer.write(manufacture.toString());
                writer.write(System.lineSeparator());
            }
        });
    }
}
