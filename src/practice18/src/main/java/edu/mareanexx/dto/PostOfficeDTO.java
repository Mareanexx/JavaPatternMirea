package edu.mareanexx.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class PostOfficeDTO {
    private Long id;
    private String name;
    private String cityName;
    private List<DepartureDTO> departures;
}
