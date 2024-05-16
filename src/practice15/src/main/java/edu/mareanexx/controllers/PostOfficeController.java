package edu.mareanexx.controllers;


import edu.mareanexx.models.PostOffice;
import edu.mareanexx.repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/postoffice")
public class PostOfficeController {
    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @GetMapping
    public Iterable<PostOffice> getPostOfficeList() {
        return postOfficeRepository.findAll();
    }

    @PostMapping
    public PostOffice postOffice(@RequestBody PostOffice newPostOffice) {
        postOfficeRepository.save(newPostOffice);
        return newPostOffice;
    }

    @DeleteMapping
    public String deletePostOffice(@RequestParam long id) {
        long postOfLength = postOfficeRepository.count();
        postOfficeRepository.deleteById(id);

        if (postOfLength != postOfficeRepository.count())
            return "Successful Delete!";
        else return "No such Departure";
    }
}
