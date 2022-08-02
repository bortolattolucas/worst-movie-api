package com.goldenraspberryawards.worstmovieapi.services;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<T, ID> {

    JpaRepository<T, ID> getRepository();

    default T save(T object) {
        return getRepository().save(object);
    }
}
