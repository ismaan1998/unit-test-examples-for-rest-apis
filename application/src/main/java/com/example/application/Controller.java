package com.example.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {


    @GetMapping("/get-data")
    public ExampleModel getData(@RequestParam(value = "name") String name) {

        ExampleModel model = new ExampleModel();
        model.setId(1);
        model.setName(name);

        return model;
    }

    @PostMapping("create-data")
    public ResponseEntity createData(@RequestBody ExampleModel model){

        return new ResponseEntity(
                String.format("data is successfully created"),
                HttpStatus.CREATED
        );



    }

}

