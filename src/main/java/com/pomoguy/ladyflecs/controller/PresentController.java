package com.pomoguy.ladyflecs.controller;


import com.pomoguy.ladyflecs.model.Lady;
import com.pomoguy.ladyflecs.model.api.GetPresentResponse;
import com.pomoguy.ladyflecs.service.LadyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("/present")
public class PresentController {

    @Autowired
    LadyService ladyService;

    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "Получить подарочек <3")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    public ResponseEntity<GetPresentResponse> getPresent(@PathVariable("name") String name) {
        try {
            Lady lady = ladyService.getLady(name);

            GetPresentResponse response = new GetPresentResponse(lady.getUrl(), lady.getName(), "Никогда ничего не бойтесь, живите здесь и сейчас, кайфуйте, жизнь одна. КАЙФУЙТЕ!!!!");


            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
