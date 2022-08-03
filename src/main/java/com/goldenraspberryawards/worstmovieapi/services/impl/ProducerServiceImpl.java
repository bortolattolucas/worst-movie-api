package com.goldenraspberryawards.worstmovieapi.services.impl;

import com.goldenraspberryawards.worstmovieapi.dto.ProducerIntervalDto;
import com.goldenraspberryawards.worstmovieapi.entities.Producer;
import com.goldenraspberryawards.worstmovieapi.repositories.ProducerRepository;
import com.goldenraspberryawards.worstmovieapi.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;
import static java.lang.String.valueOf;

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
    public List<ProducerIntervalDto> findIntervals(boolean isMaximum) {
        List<ProducerIntervalDto> list = new ArrayList<>();

        for (Object object : isMaximum ? producerRepository.findMaxIntervals() : producerRepository.findMinIntervals()) {
            list.add(mapQueryObjectToProducerIntervalDto(object));
        }

        return list;
    }

    private ProducerIntervalDto mapQueryObjectToProducerIntervalDto(Object object) {
        ProducerIntervalDto dto = new ProducerIntervalDto();
        dto.setPreviousWin(((Object[]) object)[0].toString());
        dto.setFollowingWin(((Object[]) object)[1].toString());
        dto.setProducer(producerRepository.findById(parseLong((((Object[]) object)[2]).toString())).get().getName());
        dto.setInterval(valueOf(parseLong(dto.getFollowingWin()) - parseLong(dto.getPreviousWin())));
        return dto;
    }

    @Override
    public JpaRepository<Producer, Long> getRepository() {
        return producerRepository;
    }
}
