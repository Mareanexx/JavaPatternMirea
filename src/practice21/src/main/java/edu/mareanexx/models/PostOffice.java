package edu.mareanexx.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //значение генерируется с помощью автоинкеремент
    private Long id;
    private String name;
    private String cityName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_office_id") // This column will be added to Departure table
    private List<Departure> departures;
}
