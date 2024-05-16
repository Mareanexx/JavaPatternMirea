package edu.mareanexx.controllers;

import edu.mareanexx.models.PostOffice;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/postoffice")
public class PostOfficeController {
    private List<PostOffice> postOfficeList = new ArrayList<>();

    @GetMapping
    public List<PostOffice> getPostOfficeList() {
        return postOfficeList;
    }

    @PostMapping
    public PostOffice postOffice(@RequestBody PostOffice newPostOffice) {
        postOfficeList.add(newPostOffice);
        return newPostOffice;
    }

    @DeleteMapping
    public String deletePostOffice(@RequestBody PostOffice postOffice2) {
        int postOfLength = postOfficeList.size();
        postOfficeList = new ArrayList<>(postOfficeList.stream()
                .filter(postOffice -> !postOffice.equals(postOffice2))
                .toList());
        if (postOfLength != postOfficeList.size())
            return "Successful Delete!";
        else return "No such Departure";
    }
}
