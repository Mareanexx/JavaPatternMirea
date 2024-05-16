package edu.mareanexx.controllers;

import edu.mareanexx.models.Departure;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/departure")
public class DepartureController {
    private List<Departure> departureList = new ArrayList<>();

    @GetMapping
    public List<Departure> getDepartureList() {
        return departureList;
    }

    @PostMapping
    public Departure postDeparture(@RequestBody Departure newDeparture) {
        departureList.add(newDeparture);
        return newDeparture;
    }

    @DeleteMapping
    public String deleteDeparture(@RequestBody Departure depart) {
        int departListLength = departureList.size();
        departureList = new ArrayList<>(departureList.stream()
                .filter(departure -> !departure.equals(depart))
                .toList());
        if (departListLength != departureList.size())
            return "Successful Delete!";
        else return "No such Departure";
    }
}