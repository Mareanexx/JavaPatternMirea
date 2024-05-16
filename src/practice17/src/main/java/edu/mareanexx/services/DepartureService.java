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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartureService {
    @Autowired
    private DepartureRepository departureRepository;
    @PersistenceContext
    private EntityManager entityManager;

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
    public List<Departure> findDeparturesByType(String searchType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departure> cq = cb.createQuery(Departure.class);
        Root<Departure> departureRoot = cq.from(Departure.class);
        Predicate typePredicate = cb.equal(departureRoot.get("type"), searchType);
        cq.where(typePredicate);

        return entityManager.createQuery(cq).getResultList();
    }

    @Transactional
    public List<Departure> sortDeparturesByDate() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departure> cq = cb.createQuery(Departure.class);
        Root<Departure> departureRoot = cq.from(Departure.class);
        cq.orderBy(cb.asc(departureRoot.get("departureDate")));

        return entityManager.createQuery(cq).getResultList();
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
