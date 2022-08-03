package com.goldenraspberryawards.worstmovieapi.services.impl;

import com.goldenraspberryawards.worstmovieapi.entities.Award;
import com.goldenraspberryawards.worstmovieapi.repositories.AwardRepository;
import com.goldenraspberryawards.worstmovieapi.services.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements AwardService {

    private final AwardRepository AwardRepository;

    @Autowired
    public AwardServiceImpl(AwardRepository AwardRepository) {
        this.AwardRepository = AwardRepository;
    }

    @Override
    public JpaRepository<Award, Long> getRepository() {
        return AwardRepository;
    }
}
