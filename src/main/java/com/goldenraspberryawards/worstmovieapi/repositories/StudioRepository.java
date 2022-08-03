package com.goldenraspberryawards.worstmovieapi.repositories;

import com.goldenraspberryawards.worstmovieapi.entities.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {

    @Query("SELECT DISTINCT obj FROM Studio obj " +
            "WHERE " +
            "LOWER(obj.name) = LOWER(:name)")
    Studio findByName(String name);
}
