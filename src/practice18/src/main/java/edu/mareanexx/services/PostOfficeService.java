package edu.mareanexx.services;

import edu.mareanexx.models.PostOffice;
import edu.mareanexx.repositories.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PostOfficeService {
    @Autowired
    private PostOfficeRepository postOfficeRepository;
    public List<PostOffice> getPostOfficeList() {
        return postOfficeRepository.findAll();
    }
    public PostOffice savePostOffice(PostOffice newPostOffice) {
        return postOfficeRepository.save(newPostOffice);
    }

    public PostOffice findPostOfficeById(Long id) {
        return postOfficeRepository.findById(id).orElseThrow(() -> new RuntimeException("PostOffice not found!"));
    }

    @Transactional
    public void deletePostOfficeById(Long id) {
        PostOffice postOffice = postOfficeRepository.findById(id).orElseThrow(() -> new RuntimeException("PostOffice not found!"));
        // Каскадное удаление должно автоматически удалить все Departure
        postOfficeRepository.delete(postOffice);
    }
}
