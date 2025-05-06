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
        // Créer un mock pour Voiture
        Voiture voiture1 = mock(Voiture.class);
        Voiture voiture2 = mock(Voiture.class);
        
        // Définir ce que les méthodes 'getPrix()' des voitures simulées doivent retourner
        when(voiture1.getPrix()).thenReturn(500);
        when(voiture2.getPrix()).thenReturn(1000);
        
        // Ajouter les voitures à la liste de voitures dans StatistiqueImpl (via le mock)
        statistiqueImpl.ajouter(voiture1);
        statistiqueImpl.ajouter(voiture2);
        
        // Appeler la méthode 'prixMoyen' sur le mock de StatistiqueImpl
        Echantillon echantillon = statistiqueImpl.prixMoyen();
        
        // Vérifier que le nombre de voitures et le prix moyen sont corrects
        assertNotNull(echantillon);  // Vérifie que le résultat n'est pas nul
        assertEquals(2, echantillon.getNombreDeVoitures());  // Vérifie que le nombre de voitures est 2
        assertEquals(750, echantillon.getPrixMoyen());  // Vérifie que le prix moyen est (500 + 1000) / 2 = 750
    }
}
