package com.goldenraspberryawards.worstmovieapi.services;

import com.goldenraspberryawards.worstmovieapi.entities.Studio;
import com.goldenraspberryawards.worstmovieapi.repositories.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudioService implements GenericService<Studio, Long> {

    private final StudioRepository studioRepository;

    @Autowired
    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public JpaRepository<Studio, Long> getRepository() {
        return studioRepository;
    }
}
