package edu.mareanexx.services;

import edu.mareanexx.models.*;
import edu.mareanexx.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DepartureServiceTest {
    @Mock
    private DepartureRepository departureRepository;
    @InjectMocks
    private DepartureService departureService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("DepartureService#GetDepartureList test")
    void testGetDepartureList() {
        // Arrange
        Departure departure1 = new Departure();
        departure1.setType("mail");
        Departure departure2 = new Departure();
        departure2.setType("package");
        when(departureRepository.findAll()).thenReturn(List.of(departure1, departure2));

        // Act
        List<Departure> result = departureService.getDepartureList();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("mail", result.get(0).getType());
        assertEquals("package", result.get(1).getType());
    }

    @Test
    @DisplayName("DepartureService#saveDeparture test")
    void testSaveDeparture() {
        // Arrange
        Departure newDeparture = new Departure();
        newDeparture.setType("mail");
        when(departureRepository.save(any(Departure.class))).thenReturn(newDeparture);

        // Act
        Departure savedDeparture = departureService.saveDeparture(newDeparture);

        // Assert
        assertNotNull(savedDeparture);
        assertEquals("mail", savedDeparture.getType());
    }

    @Test
    @DisplayName("DepartureService#deleteDeparture test")
    void testDeleteDeparture() {
        // Arrange
        Long id = 1L;
        Departure departureToDelete = new Departure();
        departureToDelete.setType("mail");
        departureToDelete.setId(id);
        when(departureRepository.findById(id)).thenReturn(Optional.of(departureToDelete));

        // Act
        departureService.deleteDepartureById(id);

        // Assert
        verify(departureRepository, times(1)).delete(departureToDelete);
    }
}
