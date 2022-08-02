package com.goldenraspberryawards.worstmovieapi.services;

import com.goldenraspberryawards.worstmovieapi.entities.Producer;
import com.goldenraspberryawards.worstmovieapi.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProducerService implements GenericService<Producer, Long> {

    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public JpaRepository<Producer, Long> getRepository() {
        return producerRepository;
    }
}
