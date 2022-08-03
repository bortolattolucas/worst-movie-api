package com.goldenraspberryawards.worstmovieapi.services;

import com.goldenraspberryawards.worstmovieapi.dto.ProducerIntervalDto;
import com.goldenraspberryawards.worstmovieapi.entities.Producer;

import java.util.List;

public interface ProducerService extends GenericService<Producer, Long> {

    Producer findByName(String name);

    List<ProducerIntervalDto> findIntervals(boolean isMaximum);
}
