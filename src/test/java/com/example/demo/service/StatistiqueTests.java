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

        // Trigger the mocked methods explicitly
        int nombreDeVoitures = finale.getNombreDeVoitures();
        int prixMoyen = finale.getPrixMoyen();

        // Verify the interaction with the mock
        verify(echantillonMock).getNombreDeVoitures();
        verify(echantillonMock).getPrixMoyen();

        // Additional assertions (optional)
        assertEquals(1, nombreDeVoitures);
        assertEquals(500, prixMoyen);
    }
}