package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture tonobil = new Voiture("ferari",500);
        tonobil.setId(2);
        assertEquals(tonobil.getId(), 2);
        assertEquals(tonobil.getMarque(), "ferari");
        assertEquals(tonobil.getPrix(), 500 );
        tonobil.setPrix(600);
        tonobil.setMarque("zz");
        assertEquals(tonobil.getMarque(), "zz");
        assertEquals(tonobil.getPrix(), 600 );

    }

}
