package com.example.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/get-data")
    public ExampleModel getData(@RequestParam(value = "name") String name) {

        ExampleModel model = new ExampleModel();
        model.setId(1);
        model.setName(name);

        return model;
    }
}