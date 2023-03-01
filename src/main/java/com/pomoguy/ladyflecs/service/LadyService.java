package com.pomoguy.ladyflecs.service;

import com.pomoguy.ladyflecs.dao.LadyRepo;
import com.pomoguy.ladyflecs.model.Lady;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LadyService {

    @Autowired
    private LadyRepo ladyRepo;

    public void addLady(Object request) {

        try {
            Lady lady = (Lady) request;
            ladyRepo.save(lady);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    public Lady getLady(String name) {
        Lady lady;
        try {
            Optional<Lady> ladyOptional = ladyRepo.findByName(name);
            if (ladyOptional.isPresent()) {
                lady = ladyOptional.get();
            } else {
                throw new Exception("Lady not found");
            }
            return lady;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
