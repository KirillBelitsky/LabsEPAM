package com.controller;

import com.controller.RectangleController;
import com.errorPages.InternalServerError;
import com.service.RectangleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.shortThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RectangleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RectangleService rectangleService;

    @MockBean
    private RectangleController rectangleController;

    @Test
    public void greetingOkTest() throws Exception{
        when(rectangleService.validate("2","3")).thenReturn(true);
        when(rectangleController.greeting("2","3")).thenReturn(new ResponseEntity("Ok",HttpStatus.OK));
    }

    @Test
    public void greetingBadRequestTest() throws Exception{
        when(rectangleService.validate("-2","2")).thenReturn(false);
        when(rectangleController.greeting("-2","2")).thenReturn(new ResponseEntity("Bad_Request", HttpStatus.BAD_REQUEST));
    }

    @Test
    public void greetingIntServErrorTest(){
        when(rectangleService.validate("999","2")).thenReturn(true);
        when(rectangleController.greeting("999","2")).thenReturn(new ResponseEntity("Bad_Request", HttpStatus.INTERNAL_SERVER_ERROR));
    }
}