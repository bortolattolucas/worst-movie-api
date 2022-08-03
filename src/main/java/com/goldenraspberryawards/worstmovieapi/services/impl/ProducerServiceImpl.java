package com.goldenraspberryawards.worstmovieapi.services.impl;

import com.goldenraspberryawards.worstmovieapi.entities.Producer;
import com.goldenraspberryawards.worstmovieapi.repositories.ProducerRepository;
import com.goldenraspberryawards.worstmovieapi.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public Producer findByName(String name) {
        return producerRepository.findByName(name);
    }

    @Override
    public JpaRepository<Producer, Long> getRepository() {
        return producerRepository;
    }
}
