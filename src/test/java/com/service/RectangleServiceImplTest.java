package com.service;

import com.entity.Rectangle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RectangleServiceImplTest {


    @MockBean
    private RectangleService rectangleService;


    @Test
    public void processShouldReturnEntity (){
        when(rectangleService.process("2","4")).thenReturn(new Rectangle("8","12"));
        when(rectangleService.process("5","5")).thenReturn(new Rectangle("25","20"));
    }

    @Test
    public void validateShouldReturnBoollean(){
        when(rectangleService.validate("2","4")).thenReturn(true);
        when(rectangleService.validate("2","dsf")).thenReturn(false);
        when(rectangleService.validate("0","10")).thenReturn(false);
    }

}