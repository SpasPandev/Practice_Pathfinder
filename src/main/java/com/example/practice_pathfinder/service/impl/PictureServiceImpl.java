package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.repository.PictureRepository;
import com.example.practice_pathfinder.service.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllPicturesUrls() {
        return pictureRepository.findAllUrls();
    }
}
