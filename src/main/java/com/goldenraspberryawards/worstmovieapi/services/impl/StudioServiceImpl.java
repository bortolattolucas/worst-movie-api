package com.goldenraspberryawards.worstmovieapi.services.impl;

import com.goldenraspberryawards.worstmovieapi.entities.Studio;
import com.goldenraspberryawards.worstmovieapi.repositories.StudioRepository;
import com.goldenraspberryawards.worstmovieapi.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudioServiceImpl implements StudioService {

    private final StudioRepository studioRepository;

    @Autowired
    public StudioServiceImpl(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public Studio findByName(String name) {
        return studioRepository.findByName(name);
    }

    @Override
    public JpaRepository<Studio, Long> getRepository() {
        return studioRepository;
    }
}
