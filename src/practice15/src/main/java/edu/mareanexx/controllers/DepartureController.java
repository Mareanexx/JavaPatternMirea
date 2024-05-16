package edu.mareanexx.controllers;

import edu.mareanexx.models.Departure;
import edu.mareanexx.repository.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/departure")
public class DepartureController {

    @Autowired
    private DepartureRepository departureRepository;

    @GetMapping
    public Iterable<Departure> getDepartureList() {
        return departureRepository.findAll();
    }

    @PostMapping
    public Departure postDeparture(@RequestBody Departure newDeparture) {
        return departureRepository.save(newDeparture);
    }

    @DeleteMapping
    public String deleteDeparture(@RequestParam long id) {
        long departureRepositoryLength = departureRepository.count();
        departureRepository.deleteById(id);

        if (departureRepositoryLength != departureRepository.count())
            return "Successful Delete!";
        else return "No such Departure";
    }
}

