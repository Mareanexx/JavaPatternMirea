package edu.mareanexx.services;


import edu.mareanexx.dto.DepartureDTO;
import edu.mareanexx.dto.PostOfficeDTO;
import edu.mareanexx.mapper.Mapper;
import edu.mareanexx.models.Departure;
import edu.mareanexx.models.PostOffice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchedulerService {
    private final DepartureService departureService;
    private final PostOfficeService postOfficeService;
    private final Mapper mapperToDTO;

    @Scheduled(fixedRate = 1800000)
    @Async
    public void backup() {
        cleanBackUpFolder();
        backupPostOffices();
        backupDepartures();
    }

    private static void cleanBackUpFolder() {
        File folder = new File("src/main/resources/backup");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.delete()) {
                    log.error("Failed to erase the backup folder and file {}", file);
                }
            }
        }
    }

    private void backupPostOffices() {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/backup/postoffices.txt", StandardCharsets.UTF_8);
            writer.print("");
            List<PostOffice> postOfficeList = postOfficeService.getPostOfficeList();
            List<PostOfficeDTO> postOfficeDTOS = new ArrayList<>();
            if (!postOfficeList.isEmpty()) {
                for (PostOffice postOffice : postOfficeList) {
                    postOfficeDTOS.add(mapperToDTO.mapToDTO(postOffice));
                }
                for (PostOfficeDTO postOfficeDTO : postOfficeDTOS) {
                    writer.append(postOfficeDTO.toString()).append("\n");
                }
                writer.close();
                log.info("PostOffice backup complete!");
            } else {
                log.info("PostOffice is empty, wasn't backuped");
            }
        } catch (Exception e) {
            log.error("Failed to backup Postoffices", e);
        }
    }

    private void backupDepartures() {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/backup/departures.txt", StandardCharsets.UTF_8);
            writer.print("");
            List<Departure> departureList = departureService.getDepartureList();
            List<DepartureDTO> departureDTOS = new ArrayList<>();
            if (!departureList.isEmpty()) {
                for (Departure departure : departureList) {
                    departureDTOS.add(mapperToDTO.mapToDTO(departure));
                }
                for (DepartureDTO departureDTO : departureDTOS) {
                    writer.append(departureDTO.toString()).append("\n");
                }
                writer.close();
                log.info("Departure backup complete!");
            } else {
                log.info("DepartureList is empty, wasn't backuped");
            }
        } catch (Exception e) {
            log.error("Failed to backup Departure", e);
        }
    }
}
