package com.controller;

import com.entity.Rectangle;
import com.errorPages.InternalServerError;
import com.service.rectangle.RectangleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RectangleController {

    private RectangleService rectangleService;
    private static final Logger log = Logger.getLogger(RectangleController.class);

    @Autowired
    public RectangleController(RectangleService rectangleService) {
        this.rectangleService = rectangleService;
    }

    @RequestMapping("/rectangle")
    public ResponseEntity<Rectangle> rectangle(@RequestParam(value = "length") String length,
                                               @RequestParam(value = "width") String width) {

        //log.debug("Start method greeting!");

        if (rectangleService.validate(length, width)) {
            //log.debug("Validation is succefully!");

            if(Integer.parseInt(length) == 999 ||Integer.parseInt(width)==999) {
                //log.error("500 Error!");
                throw new InternalServerError();
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "RectangleController");

            //log.debug("Good Job!");

            return ResponseEntity.accepted().headers(headers).body(rectangleService.process(length,width));
        }

        //log.error("Bad Request!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
