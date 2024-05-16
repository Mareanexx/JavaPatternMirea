package edu.mareanexx.mapper;


import edu.mareanexx.dto.DepartureDTO;
import edu.mareanexx.dto.PostOfficeDTO;
import edu.mareanexx.models.Departure;
import edu.mareanexx.models.PostOffice;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {
    public PostOfficeDTO mapToDTO(PostOffice postOffice) {
        PostOfficeDTO dto = new PostOfficeDTO();
        dto.setId(postOffice.getId());
        dto.setName(postOffice.getName());
        dto.setCityName(postOffice.getCityName());
        // Инициализация коллекции departures
        if (postOffice.getDepartures() != null) {
            postOffice.getDepartures().size(); // или можно использовать stream()
        }

        dto.setDepartures(postOffice.getDepartures().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public DepartureDTO mapToDTO(Departure departure) {
        DepartureDTO dto = new DepartureDTO();
        dto.setId(departure.getId());
        dto.setType(departure.getType());
        dto.setDepartureDate(departure.getDepartureDate());
        dto.setPostOfficeId(departure.getPostOffice().getId());
        return dto;
    }
}
