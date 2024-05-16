package edu.mareanexx.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PostOfficeDTO {
    private Long id;
    private String name;
    private String cityName;
    private List<DepartureDTO> departures;
}
