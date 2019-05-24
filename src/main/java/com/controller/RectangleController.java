package com.controller;

import com.entity.*;
import com.errorPages.InternalServerError;
import com.service.rectangle.RectangleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class RectangleController {

    private RectangleService rectangleService;
    private static final Logger log = Logger.getLogger(RectangleController.class);

    @Autowired
    public RectangleController(RectangleService rectangleService) {
        this.rectangleService = rectangleService;
    }

    @GetMapping("/rectangle")
    public ResponseEntity<Rectangle> rectangle(@RequestParam(value = "length") String length,
                                               @RequestParam(value = "width") String width) {

        if (rectangleService.validate(length, width)){
            if(Integer.parseInt(length) == 999 ||Integer.parseInt(width)==999){
                throw new InternalServerError();
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "RectangleController");

            return ResponseEntity.accepted().headers(headers).body(rectangleService.process(length,width));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


    @GetMapping("/all")
    public List<CacheResult> getAll(){
        return rectangleService.getAll();
    }

    @PostMapping("/rectangle/async")
    public ResponseEntity<String> processListAsync(@RequestBody List<Parameters> list){
        return ResponseEntity.ok().body(rectangleService.asynchCalculate(list).toString());
    }

    @GetMapping("/get/async/{id}")
    public List<Rectangle> getAsyncrAnswers(@PathVariable("id") String id){
        return rectangleService.getAnswerById(id);
    }

}
