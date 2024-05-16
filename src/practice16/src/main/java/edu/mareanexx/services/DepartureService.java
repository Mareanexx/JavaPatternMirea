package edu.mareanexx.services;

import edu.mareanexx.models.Departure;
import edu.mareanexx.models.PostOffice;
import edu.mareanexx.repositories.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartureService {
    @Autowired
    private DepartureRepository departureRepository;

    public List<Departure> getDepartureList() {
        return departureRepository.findAll();
    }

    public Departure saveDeparture(Departure newDeparture) {
        return departureRepository.save(newDeparture);
    }

    public Departure findDepartureById(Long id) {
        return departureRepository.findById(id).orElseThrow(() -> new RuntimeException("PostOffice not found!"));
    }
    @Transactional
    public void deleteDepartureById(Long id) {
        Departure departure = departureRepository.findById(id).orElseThrow(() -> new RuntimeException("Departure not found"));
        PostOffice postOffice = departure.getPostOffice();
        if (postOffice != null) {
            postOffice.getDepartures().remove(departure); // Удаляем Departure из списка PostOffice
        }
        departureRepository.delete(departure); // Удаляем Departure
    }
}
