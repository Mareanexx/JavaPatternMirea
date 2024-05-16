package edu.mareanexx.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DepartureDTO {

    private Long id;

    private String type;
    private String departureDate;
    private Long postOfficeId;
}
