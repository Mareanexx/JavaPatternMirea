package edu.mareanexx.controllers;


import edu.mareanexx.dto.PostOfficeDTO;
import edu.mareanexx.mapper.Mapper;
import edu.mareanexx.models.PostOffice;
import edu.mareanexx.services.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/postoffice")
public class PostOfficeController {
    @Autowired
    private PostOfficeService postOfficeService;
    @Autowired
    private Mapper mapper;

    @GetMapping
    public ResponseEntity<List<PostOfficeDTO>> getPostOfficeList() {
        List<PostOffice> postOfficeList = postOfficeService.getPostOfficeList();
        List<PostOfficeDTO> postOfficeDTOS = new ArrayList<>();
        if (!postOfficeList.isEmpty()) {
            for (PostOffice postOffice : postOfficeList) {
                postOfficeDTOS.add(mapper.mapToDTO(postOffice));
            }
            return ResponseEntity.ok(postOfficeDTOS);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public PostOfficeDTO savePostOffice(@RequestBody PostOffice newPostOffice) { // тут что то подозрительное
        if (newPostOffice.getDepartures() != null) {
            newPostOffice.getDepartures().forEach(departure -> departure.setPostOffice(newPostOffice));
        }
        postOfficeService.savePostOffice(newPostOffice);
        return mapper.mapToDTO(newPostOffice);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PostOfficeDTO> deletePostOffice(@PathVariable Long id) {
        PostOffice deletePostOffice = postOfficeService.findPostOfficeById(id);
        if (deletePostOffice != null) {
            postOfficeService.deletePostOfficeById(id);
            return ResponseEntity.ok(mapper.mapToDTO(deletePostOffice));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
