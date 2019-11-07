package com.capgemini.tdd.demo;

import com.capgemini.tdd.demo.services.NumberService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberServiceTests {

    NumberService service = new NumberService();

    @Test
    void convert10(){
        assertEquals("Ten", service.convert(10));
    }

    @Test
    void convert21(){
        assertEquals("Twenty One", service.convert(21));
    }

    @Test
    void convert515(){
        assertEquals("Five Hundred and Fifteen", service.convert(515));
    }

    @Test
    void convert0(){
        assertEquals("Zero", service.convert(0));
    }

    @Test
    void convert420(){
        assertEquals("Four Hundred and Twenty", service.convert(420));
    }

    @Test
    void convert999(){
        assertEquals("Nine Hundred and Ninety Nine", service.convert(999));
    }

    @Test
    void convert790(){
        assertEquals("Severn Hundred and Ninety", service.convert(790));
    }

    @Test
    void convert219(){
        assertEquals("Two Hundred and Nineteen", service.convert(219));
    }

    @Test
    void convert1001(){
        assertEquals("One Thousand and One", service.convert(1001));
    }

    @Test
    void convert2011(){
        assertEquals("Two Thousand and Eleven", service.convert(2011));
    }

    @Test
    void convert3282(){
        assertEquals("Three Thousand, Two Hundred and Eighty Two", service.convert(3282));
    }

    @Test
    void convert0To9999(){
        int i = 0;
        while(i<999){
            System.out.println(service.convert(i));
            i++;
        }
        assertEquals("Nine Hundred and Ninety Nine", service.convert(999));
    }

}
