package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatistiqueTests {

    @MockBean
    private StatistiqueImpl statistiqueImpl;

    @Test
    public void testCalculeST() {

        // Créer un objet Voiture
        Voiture tonobil = new Voiture("Ferrari", 500);
        tonobil.setId(55);

        // Simuler l'ajout de la voiture dans statistiqueImpl
        statistiqueImpl.ajouter(tonobil);

        // Créer un mock pour l'objet Echantillon
        Echantillon echantillonMock = mock(Echantillon.class);

        
        when(echantillonMock.getNombreDeVoitures()).thenReturn(1);
        when(echantillonMock.getPrixMoyen()).thenReturn(500);

        // Appeler la méthode prixMoyen et récupérer le résultat
        Echantillon finale = statistiqueImpl.prixMoyen();

        // Vérifier que les méthodes de Echantillon ont bien été appelées
        verify(echantillonMock).getNombreDeVoitures();
        verify(echantillonMock).getPrixMoyen();
    }
}
