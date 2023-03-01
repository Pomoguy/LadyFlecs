package com.pomoguy.ladyflecs.dao;

import com.pomoguy.ladyflecs.model.Lady;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LadyRepo extends CrudRepository<Lady, Integer> {
    Optional<Lady> findByName(String name);
}
