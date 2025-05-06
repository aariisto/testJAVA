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
    // Create a mock for Echantillon
        Echantillon echantillonMock = mock(Echantillon.class);

        // Set up the mock behavior
        when(echantillonMock.getNombreDeVoitures()).thenReturn(1);
        when(echantillonMock.getPrixMoyen()).thenReturn(500);

        // Inject the mock into statistiqueImpl
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillonMock);

        // Call the method to test
        Echantillon finale = statistiqueImpl.prixMoyen();

        // Verify the interaction with the mock
        verify(echantillonMock).getNombreDeVoitures();
        verify(echantillonMock).getPrixMoyen();

}

}
