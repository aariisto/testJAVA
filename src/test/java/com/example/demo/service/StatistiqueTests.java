package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatistiqueTests {

    // Mock de StatistiqueImpl (on va simuler son comportement)
    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test

public void testCalculePrixMoyen() {
    // Create mock objects for Voiture
    Voiture voiture1 = mock(Voiture.class);
    Voiture voiture2 = mock(Voiture.class);

    // Mock the behavior of 'getPrix()' for the voiture objects
    when(voiture1.getPrix()).thenReturn(500);
    when(voiture2.getPrix()).thenReturn(1000);

    // Mock the behavior of 'ajouter()' and 'prixMoyen()' for StatistiqueImpl
    Echantillon mockEchantillon = mock(Echantillon.class);
    when(statistiqueImpl.prixMoyen()).thenReturn(mockEchantillon);
    when(mockEchantillon.getNombreDeVoitures()).thenReturn(2);
    when(mockEchantillon.getPrixMoyen()).thenReturn(500);

    // Add voitures to the mocked StatistiqueImpl
    statistiqueImpl.ajouter(voiture1);
    statistiqueImpl.ajouter(voiture2);

    // Call the 'prixMoyen()' method
    Echantillon echantillon = statistiqueImpl.prixMoyen();

    // Validate the result
    assertNotNull(echantillon);  // Check that the result is not null
    assertEquals(2, echantillon.getNombreDeVoitures());  // Verify the number of voitures
    assertEquals(750, echantillon.getPrixMoyen());  // Verify the average price
}

}
