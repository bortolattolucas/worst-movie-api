package com.goldenraspberryawards.worstmovieapi.repositories;

import com.goldenraspberryawards.worstmovieapi.entities.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {
}
