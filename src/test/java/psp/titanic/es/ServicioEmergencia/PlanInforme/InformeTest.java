package psp.titanic.es.ServicioEmergencia.PlanInforme;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InformeTest {

    private Informe informe;

    @BeforeEach
    void setUp() {
        informe = new Informe();
    }

    @Test
    void testCrearInformeFinal() throws IOException {
        informe.escribirInforme("B00: 12\n");
        String ruta = "doc/InformeTest.md";
        int totalSobreviviente = 35;

        informe.crearInformeFinal(ruta, totalSobreviviente);

        File file = new File(ruta);
        String contenido = Files.readString(file.toPath());
        assertTrue(contenido.contains("B00: 12"));
        assertTrue(contenido.contains("Se han rescatado a 35 personas."));
        assertTrue(contenido.contains("Ejecución realizada el día"));

        file.delete();
    }
}
