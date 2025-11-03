package psp.titanic.es.ServicioEmergencia;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmergenciaTest {

    @Mock
    private Emergencia emergenciaMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        emergenciaMock = mock(Emergencia.class);
    }

    @Test
    void testLanzarBote() throws IOException, InterruptedException {
        String[] comando = {"comando"};
        when(emergenciaMock.lanzarBote(comando, "Error", 100, 50)).thenReturn("12,15,4,7\n");

        String resultado = emergenciaMock.lanzarBote(comando, "Error", 100, 50);

        assertEquals("12,15,4,7\n", resultado);
        verify(emergenciaMock, times(1)).lanzarBote(comando, "Error", 100, 50);
    }

    @Test
    void testContarSobreviviente() {
        Emergencia emergencia = new Emergencia();
        String[] sobrevivientes1 = {"10","5","2","8"};
        String[] sobrevivientes2 = {"3","6","1","4"};
        emergencia.contarSobreviviente(sobrevivientes1);
        emergencia.contarSobreviviente(sobrevivientes2);
        assertEquals(12, emergencia.getSobrevivienteTotal());
    }
}
