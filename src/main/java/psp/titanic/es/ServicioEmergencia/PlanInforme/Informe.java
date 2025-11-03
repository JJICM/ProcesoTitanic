package psp.titanic.es.ServicioEmergencia.PlanInforme;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Informe {

    private String informe = "";

    public void crearInformeFinal(final String RUTA_INFORME, int totalSobreviviente) throws IOException {
        StringBuilder informeFinal = new StringBuilder();
        informeFinal.append("# SERVICIO DE EMERGENCIAS").append("\n\n")
                .append(escribirFecha()).append("\n\n")
                .append("Se han rescatado a ").append(totalSobreviviente).append(" personas.").append("\n")
                .append(informe);

        FileWriter fw = new FileWriter(RUTA_INFORME);
        fw.write(informeFinal.toString());
        fw.close();
    }

    public void escribirInforme(String sobrevivientes) {
        informe += sobrevivientes;
    }

    public String escribirFecha() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' HH:mm:ss");
        return "Ejecución realizada el día " + now.format(formato);
    }

}
