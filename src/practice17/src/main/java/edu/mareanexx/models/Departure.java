package edu.mareanexx.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //значение генерируется с помощью автоинкеремент
    private Long id;

    private String type;
    private String departureDate;

    @ManyToOne
    @JoinColumn(name = "post_office_id", insertable = false, updatable = false)
    private PostOffice postOffice;
}
