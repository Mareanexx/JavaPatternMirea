package edu.mareanexx.controllers;

import edu.mareanexx.dto.DepartureDTO;
import edu.mareanexx.mapper.Mapper;
import edu.mareanexx.models.Departure;
import edu.mareanexx.services.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/departure")
public class DepartureController {
    @Autowired
    private DepartureService departureService;
    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<List<DepartureDTO>> getDepartureList() {
        List<Departure> departureList = departureService.getDepartureList();
        List<DepartureDTO> departureDTOS = new ArrayList<>();
        if (!departureList.isEmpty()) {
            for (Departure departure : departureList) {
                departureDTOS.add(mapper.mapToDTO(departure));
            }
            return ResponseEntity.ok(departureDTOS);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public DepartureDTO saveDeparture(@RequestBody Departure departure) {
        departureService.saveDeparture(departure);
        return mapper.mapToDTO(departure);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DepartureDTO> deleteDeparture(@PathVariable Long id) {
        Departure deleteDeparture = departureService.findDepartureById(id);
        if (deleteDeparture != null) {
            departureService.deleteDepartureById(id);
            return ResponseEntity.ok(mapper.mapToDTO(deleteDeparture));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filter/type")
    public ResponseEntity<List<DepartureDTO>> getFilteredByType(@RequestParam String type) {
        List<Departure> filteredDepartures = departureService.findDeparturesByType(type);
        if (!filteredDepartures.isEmpty()) {
            List<DepartureDTO> filteredDepartureDTOs = filteredDepartures.stream()
                    .map(mapper::mapToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(filteredDepartureDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filter/date")
    public ResponseEntity<List<DepartureDTO>> getSortedByDate() {
        List<Departure> sortedDepartures = departureService.sortDeparturesByDate();
        if (!sortedDepartures.isEmpty()) {
            List<DepartureDTO> filteredDepartureDTOs = sortedDepartures.stream()
                    .map(mapper::mapToDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(filteredDepartureDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}