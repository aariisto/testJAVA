package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    public void testCalculeST() {

        Voiture tonobil = new Voiture("ferari",500);
        tonobil.setId(55);

        statistiqueImpl.add(tonobil);
        Echantillon finale = statistiqueImpl.prixMoyen();
        when(finale.getNombreDeVoitures()).thenReturn(1);
        when(finale.getPrixMoyen()).thenReturn(500);

        // verify(statistiqueImpl).calculerStatistique();
        // assertEquals(expectedStat, result);
    }

}
