package edu.mareanexx.services;

import edu.mareanexx.models.PostOffice;
import edu.mareanexx.repositories.PostOfficeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class PostOfficeService {
    @Autowired
    private PostOfficeRepository postOfficeRepository;
    public List<PostOffice> getPostOfficeList() {
        log.info("Get all post offices: Start");
        return postOfficeRepository.findAll();
    }
    public PostOffice savePostOffice(PostOffice newPostOffice) {
        log.info("Add post office: Start");
        log.info("Post Office to Add: " + newPostOffice.toString());
        return postOfficeRepository.save(newPostOffice);
    }

    public PostOffice findPostOfficeById(Long id) {
        log.info("Find post office by ID: Start. Post Office ID" + id);
        return postOfficeRepository.findById(id).orElseThrow(() -> new RuntimeException("PostOffice not found!"));
    }

    @Transactional
    public void deletePostOfficeById(Long id) {
        log.info("Delete post office by ID: Start. Post Office ID" + id);
        PostOffice postOffice = postOfficeRepository.findById(id).orElseThrow(() -> new RuntimeException("PostOffice not found!"));
        // Каскадное удаление должно автоматически удалить все Departure
        postOfficeRepository.delete(postOffice);
    }
}