package com.goldenraspberryawards.worstmovieapi.services;

import com.goldenraspberryawards.worstmovieapi.entities.Award;
import com.goldenraspberryawards.worstmovieapi.repositories.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AwardService implements GenericService<Award, Long> {

    private final AwardRepository AwardRepository;

    @Autowired
    public AwardService(AwardRepository AwardRepository) {
        this.AwardRepository = AwardRepository;
    }

    @Override
    public JpaRepository<Award, Long> getRepository() {
        return AwardRepository;
    }
}
