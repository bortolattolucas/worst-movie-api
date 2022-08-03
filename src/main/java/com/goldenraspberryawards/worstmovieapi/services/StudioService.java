package com.goldenraspberryawards.worstmovieapi.services;

import com.goldenraspberryawards.worstmovieapi.entities.Studio;

public interface StudioService extends GenericService<Studio, Long> {

    Studio findByName(String name);
}
