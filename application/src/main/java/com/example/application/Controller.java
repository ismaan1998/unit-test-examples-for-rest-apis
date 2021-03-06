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
    public ResponseEntity createData(@RequestBody ExampleModel model) {

        String message = String.format("data %d is successfully created",model.getId());
        return new ResponseEntity(
                String.format(message),
                HttpStatus.CREATED
        );

    }

    @PutMapping("update-data")
    public ResponseEntity updateData(@RequestBody ExampleModel model) {

        return new ResponseEntity(
                String.format("data is successfully updated"),
                HttpStatus.OK
        );
    }

    @DeleteMapping("delete-data")
    public ResponseEntity deleteData(@RequestParam Integer id) {

        return new ResponseEntity(
                String.format("Data is deleted successfully"),
                HttpStatus.OK
        );
    }


}

