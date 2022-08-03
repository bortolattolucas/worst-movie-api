package com.goldenraspberryawards.worstmovieapi.services;

import com.goldenraspberryawards.worstmovieapi.entities.Producer;

public interface ProducerService extends GenericService<Producer, Long> {

    Producer findByName(String name);
}
