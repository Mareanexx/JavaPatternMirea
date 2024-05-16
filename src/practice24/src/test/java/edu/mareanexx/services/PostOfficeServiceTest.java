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
import static org.mockito.Mockito.*;

public class PostOfficeServiceTest {
    @Mock
    private PostOfficeRepository postOfficeRepository;
    @InjectMocks
    private PostOfficeService postOfficeService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("PostOfficeService#getAllPostoffices test")
    void testGetAllPostOffices() {
        // Arrange
        PostOffice postOffice = new PostOffice();
        postOffice.setCityName("Moscow");
        PostOffice postOffice1 = new PostOffice();
        postOffice1.setCityName("Severodvinsk");
        List<PostOffice> addedPostOfficeList = List.of(postOffice, postOffice1);
        when(postOfficeRepository.findAll()).thenReturn(List.of(postOffice, postOffice1));

        // Act
        List<PostOffice> postOfficeList = postOfficeService.getPostOfficeList();

        // Assert
        assertNotNull(postOfficeList);
        assertEquals(addedPostOfficeList, postOfficeList);
        assertEquals(addedPostOfficeList.get(0).getCityName(), postOfficeList.get(0).getCityName());
        assertEquals(addedPostOfficeList.get(1).getCityName(), postOfficeList.get(1).getCityName());
    }

    @Test
    @DisplayName("PostOfficeService#savePostOffice test")
    void testSavePostOffice() {
        // Arrange
        PostOffice newPostOffice = new PostOffice();
        newPostOffice.setCityName("New York");
        when(postOfficeRepository.save(any(PostOffice.class))).thenReturn(newPostOffice);

        // Act
        PostOffice savedPostOffice = postOfficeService.savePostOffice(newPostOffice);

        // Assert
        assertNotNull(savedPostOffice);
        assertEquals("New York", savedPostOffice.getCityName());
    }

    @Test
    @DisplayName("PostOfficeService#deletePostOffice test")
    void testDeletePostOffice() {
        // Arrange
        Long id = 1L;
        PostOffice postOfficeToDelete = new PostOffice();
        postOfficeToDelete.setId(id);
        when(postOfficeRepository.findById(id)).thenReturn(Optional.of(postOfficeToDelete));

        // Act
        postOfficeService.deletePostOfficeById(id);

        // Assert
        verify(postOfficeRepository, times(1)).delete(postOfficeToDelete);
    }

}
