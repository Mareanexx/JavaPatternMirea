package edu.mareanexx.services;

import edu.mareanexx.models.Departure;
import edu.mareanexx.models.PostOffice;
import edu.mareanexx.repositories.DepartureRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartureService {
    @Autowired
    private DepartureRepository departureRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public List<Departure> getDepartureList() {
        log.info("Get all departures: Start");
        return departureRepository.findAll();
    }

    public Departure saveDeparture(Departure newDeparture) {
        log.info("Add departure: Start");
        log.info("Departure to add: " + newDeparture.toString());
        return departureRepository.save(newDeparture);
    }

    public Departure findDepartureById(Long id) {
        log.info("Find departure by ID: Start. Departure ID" + id);
        return departureRepository.findById(id).orElseThrow(() -> new RuntimeException("PostOffice not found!"));
    }

    @Transactional
    public List<Departure> findDeparturesByType(String searchType) {
        log.info("Find departure by TYPE: Start. Departure type" + searchType);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departure> cq = cb.createQuery(Departure.class);
        Root<Departure> departureRoot = cq.from(Departure.class);
        Predicate typePredicate = cb.equal(departureRoot.get("type"), searchType);
        cq.where(typePredicate);

        return entityManager.createQuery(cq).getResultList();
    }

    @Transactional
    public List<Departure> sortDeparturesByDate() {
        log.info("Sort departures by DATE: Start");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departure> cq = cb.createQuery(Departure.class);
        Root<Departure> departureRoot = cq.from(Departure.class);
        cq.orderBy(cb.asc(departureRoot.get("departureDate")));

        log.info("Sort departures by DATE: Finish");
        return entityManager.createQuery(cq).getResultList();
    }
    @Transactional
    public void deleteDepartureById(Long id) {
        log.info("Delete departure by ID: Start. Departure ID" + id);
        Departure departure = departureRepository.findById(id).orElseThrow(() -> new RuntimeException("Departure not found"));
        PostOffice postOffice = departure.getPostOffice();
        if (postOffice != null) {
            postOffice.getDepartures().remove(departure); // Удаляем Departure из списка PostOffice
        }
        departureRepository.delete(departure); // Удаляем Departure
    }
}
