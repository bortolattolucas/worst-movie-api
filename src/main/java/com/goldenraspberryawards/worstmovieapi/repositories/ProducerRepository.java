package com.goldenraspberryawards.worstmovieapi.repositories;

import com.goldenraspberryawards.worstmovieapi.entities.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
